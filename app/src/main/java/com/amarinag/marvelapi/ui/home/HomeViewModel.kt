package com.amarinag.marvelapi.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.amarinag.marvelapi.data.db.AMGMarvelApiDatabase
import com.amarinag.marvelapi.data.db.entity.toModel
import com.amarinag.marvelapi.data.source.CharacterRemoteMediator
import com.amarinag.marvelapi.domain.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val amgMarvelApiDatabase: AMGMarvelApiDatabase,
    private val characterRemoteMediator: CharacterRemoteMediator
) : ViewModel() {

    private val pagingData: Flow<PagingData<Character>> =
        Pager(PagingConfig(20, prefetchDistance = 5), remoteMediator = characterRemoteMediator) {
            amgMarvelApiDatabase.characterDao().findAllInPages()
        }.flow.cachedIn(viewModelScope).map { pagingData -> pagingData.map { it.toModel() } }
    private val _uiState = MutableStateFlow(HomeUiState(pagingData = pagingData))
    val uiState = _uiState.asStateFlow()
}


data class HomeUiState(
    val hasError: Boolean = false,
    val error: Throwable? = null,
    val errorMessage: String? = null,
    val pagingData: Flow<PagingData<Character>>
)