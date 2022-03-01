package com.amarinag.marvelapi.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun HomeRoute(homeViewModel: HomeViewModel, navigateToDetail: (Long) -> Unit) {
    val uiState by homeViewModel.uiState.collectAsState()
    HomeScreenWithList(uiState, navigateToDetail)
}