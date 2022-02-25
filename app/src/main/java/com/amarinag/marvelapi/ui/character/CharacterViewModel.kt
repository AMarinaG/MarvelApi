package com.amarinag.marvelapi.ui.character

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amarinag.marvelapi.domain.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val stateHandle: SavedStateHandle) :
    ViewModel() {
    private val _uiState = MutableStateFlow(CharacterUiState(isLoading = true))
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(5000)
            _uiState.update { it.copy(isLoading = false) }
//            val characterId = stateHandle.get<Long>("characterId")
//            Log.d("Test", "Character: $characterId")
        }
    }
}

data class CharacterUiState(
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val character: Character? = null
)