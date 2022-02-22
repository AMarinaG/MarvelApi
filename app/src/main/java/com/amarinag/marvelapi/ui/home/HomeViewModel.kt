package com.amarinag.marvelapi.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amarinag.marvelapi.BuildConfig
import com.amarinag.marvelapi.data.network.model.MarvelApiResponse
import com.amarinag.marvelapi.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val characterRepository: CharacterRepository) :
    ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState(isLoading = true))
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = false) }
            characterRepository.getAll().fold(::onSuccess, ::onFailure)
        }
    }

    private fun onSuccess(data: MarvelApiResponse) {
        Log.d("Retrofit", "data: $data")

    }

    private fun onFailure(throwable: Throwable) {
        Log.e("Retrofit", "throwable: $throwable", throwable)
    }
}


data class HomeUiState(
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
)