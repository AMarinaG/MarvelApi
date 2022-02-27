package com.amarinag.marvelapi.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import com.amarinag.marvelapi.domain.model.Character

@ExperimentalFoundationApi
@Composable
fun HomeScreenWithGrid(uiState: HomeUiState, navigateToDetail: (Long) -> Unit) {
    val gridState = rememberLazyGridState()
    if (uiState.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "uiState: ${uiState.isLoading}")
        }
    } else {
        Scaffold { innerPadding ->
            CharacterList(
                characters = uiState.characters,
                gridState = gridState,
                navigateToCharacterDetail = navigateToDetail,
                modifier = Modifier.padding(innerPadding)
            )

        }

    }
}

@ExperimentalFoundationApi
@Composable
fun CharacterList(
    characters: List<Character>?,
    gridState: LazyGridState,
    navigateToCharacterDetail: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    if (characters?.isNullOrEmpty() == true) {
        Text(text = "Empty List")
    } else {
        LazyVerticalGrid(
            state = gridState,
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),

            modifier = modifier
        ) {
            items(characters, key = { character -> character.id }) { character ->
                CharacterCard(character = character, navigateToCharacterDetail)
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
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
