package com.amarinag.marvelapi.ui.character

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amarinag.marvelapi.domain.model.Character
import com.amarinag.marvelapi.usecase.GetCharacterByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase,
    private val stateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow(CharacterUiState(isLoading = true))
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            stateHandle.get<Long>("characterId")?.let {
                getCharacterByIdUseCase(it).fold(::onSuccess, ::onFailure)
            } ?: _uiState.update { CharacterUiState(hasError = true) }

        }
    }

    private fun onSuccess(character: Character) {
        _uiState.update { CharacterUiState(character = character) }
    }

    private fun onFailure(throwable: Throwable) {
        _uiState.update { CharacterUiState(hasError = true, error = throwable) }
    }
}

data class CharacterUiState(
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val error: Throwable? = null,
    val character: Character? = null
)