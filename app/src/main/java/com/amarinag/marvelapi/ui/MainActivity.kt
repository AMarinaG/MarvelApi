package com.amarinag.marvelapi.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.paging.ExperimentalPagingApi
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalPagingApi
@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AMGMarvelApp()
        }
    }
}