package com.amarinag.marvelapi.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amarinag.marvelapi.ui.home.HomeRoute

@Composable
fun AMGMarvelNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = AMGMarvelDestionations.HOME_ROUTE) {
        composable(AMGMarvelDestionations.HOME_ROUTE) {
            HomeRoute()
        }

    }
}