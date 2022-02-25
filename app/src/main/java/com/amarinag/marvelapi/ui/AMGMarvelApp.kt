package com.amarinag.marvelapi.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.amarinag.marvelapi.ui.theme.AMGMarvelApiTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding

@ExperimentalFoundationApi
@Composable
fun AMGMarvelApp() {
    AMGMarvelApiTheme {
        ProvideWindowInsets {
            val navController = rememberNavController()
            val navigationActions = remember(navController) {
                AMGNavigationActions(navController)
            }
            Surface(
                modifier = Modifier
                    .statusBarsPadding()
                    .navigationBarsPadding()
                    .fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                AMGMarvelNavGraph(navigationActions)
            }
        }
    }
}