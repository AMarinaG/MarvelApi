package com.amarinag.marvelapi.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@ExperimentalFoundationApi
@Composable
fun HomeRoute(homeViewModel: HomeViewModel) {
    val uiState by homeViewModel.uiState.collectAsState()
    HomeScreenWithGrid(uiState)
}