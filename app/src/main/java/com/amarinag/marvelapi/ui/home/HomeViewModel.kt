package com.amarinag.marvelapi.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amarinag.marvelapi.domain.model.Character
import com.amarinag.marvelapi.usecase.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getCharactersUseCase: GetCharactersUseCase) :
    ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState(isLoading = true))
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getCharactersUseCase().collect { it.fold(::onSuccess, ::onFailure) }
        }
    }

    private fun onSuccess(data: List<Character>) {
        _uiState.update {
            it.copy(isLoading = false, characters = data)
        }
    }

    private fun onFailure(throwable: Throwable) {
        Log.e("Retrofit", "throwable: $throwable", throwable)
    }
}


data class HomeUiState(
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val characters: List<Character>? = null
)