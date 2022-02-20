package com.amarinag.marvelapi.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.amarinag.marvelapi.ui.theme.AMGMarvelApiTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun AMGMarvelApp() {
    AMGMarvelApiTheme {
        ProvideWindowInsets {
            Surface(
                modifier = Modifier
                    .statusBarsPadding()
                    .navigationBarsPadding()
                    .fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(text = "Hola hola", modifier = Modifier.align(Alignment.TopCenter))
                    Text(text = "Hola hola", modifier = Modifier.align(Alignment.BottomCenter))
                }
            }
        }
    }
}