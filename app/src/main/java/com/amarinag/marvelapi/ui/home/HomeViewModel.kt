package com.amarinag.marvelapi.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.amarinag.marvelapi.data.source.CharacterPagingSource
import com.amarinag.marvelapi.domain.model.Character
import com.amarinag.marvelapi.usecase.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val characterPagingSource: CharacterPagingSource
) : ViewModel() {

    private val pagingData: Flow<PagingData<Character>> = Pager(PagingConfig(20)) {
        characterPagingSource
    }.flow.cachedIn(viewModelScope)
    private val _uiState = MutableStateFlow(HomeUiState(pagingData = pagingData))
    val uiState = _uiState.asStateFlow()
}


data class HomeUiState(
    val hasError: Boolean = false,
    val error: Throwable? = null,
    val errorMessage: String? = null,
    val pagingData: Flow<PagingData<Character>>
)