package com.amarinag.marvelapi.ui.character

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import com.amarinag.domain.model.Character
import com.amarinag.marvelapi.ui.commons.LoadingContent

@Composable
fun CharacterScreen(uiState: CharacterUiState) {
    LoadingContent(loading = uiState.isLoading) {
        if (uiState.character != null) {
            CharacterDetail(character = uiState.character)
        } else {
            Log.e("AMG", "HasError <> ${uiState.error} <> ${uiState.errorMessage}")

        }
    }
}

@Composable
fun CharacterDetail(character: Character) {
    val scrollState = rememberScrollState()
    LaunchedEffect(key1 = scrollState.value) {
        Log.d("CharacterDetail", "scroll to : ${scrollState.value} / ${scrollState.maxValue}")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
    ) {
        Image(
            painter = rememberImagePainter(data = character.imageUrl, builder = {
                size(OriginalSize)
            }),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = character.name)
        character.description?.let {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = it)
        }
    }

}