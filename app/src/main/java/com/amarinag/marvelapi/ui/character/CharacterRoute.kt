package com.amarinag.marvelapi.ui.character

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun CharacterRoute(characterViewModel: CharacterViewModel) {
    val uiState by characterViewModel.uiState.collectAsState()

    CharacterScreen(uiState)
}