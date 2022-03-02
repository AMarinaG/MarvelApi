package com.amarinag.marvelapi.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import com.amarinag.marvelapi.domain.model.Character
import com.amarinag.marvelapi.ui.commons.DefaultLoading
import com.amarinag.marvelapi.ui.commons.LoadingContent

@Composable
fun HomeScreenWithList(
    uiState: HomeUiState,
    navigateToDetail: (Long) -> Unit
) {
    val lazyPagingItems = uiState.pagingData.collectAsLazyPagingItems()
    LoadingContent(loading = lazyPagingItems.loadState.refresh == LoadState.Loading) {
        Scaffold { innerPadding ->
            CharacterList(
                lazyPagingItems = lazyPagingItems,
                navigateToCharacterDetail = navigateToDetail,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun CharacterList(
    lazyPagingItems: LazyPagingItems<Character>,
    navigateToCharacterDetail: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(
            lazyPagingItems,
            key = { character -> character.id }) { character ->
            CharacterCard(
                character = character!!,
                navigateToCharacter = navigateToCharacterDetail
            )
        }
        if (lazyPagingItems.loadState.append == LoadState.Loading) {
            item {
                DefaultLoading(modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun CharacterCard(
    character: Character,
    navigateToCharacter: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier
        .height(200.dp)
        .clickable { navigateToCharacter(character.id) }) {

        Box {
            Image(
                painter = rememberImagePainter(data = character.imageUrl, builder = {
                    size(OriginalSize)
                }),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .background(Color.Black.copy(alpha = 0.5F))
                    .padding(16.dp)
            ) {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.h5,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
