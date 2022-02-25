package com.amarinag.marvelapi.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amarinag.marvelapi.ui.character.CharacterRoute
import com.amarinag.marvelapi.ui.character.CharacterViewModel
import com.amarinag.marvelapi.ui.home.HomeRoute
import com.amarinag.marvelapi.ui.home.HomeViewModel

@ExperimentalFoundationApi
@Composable
fun AMGMarvelNavGraph(
    navigationActions: AMGNavigationActions,
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = AMGMarvelDestinations.HOME_ROUTE) {
        composable(AMGMarvelDestinations.HOME_ROUTE) {
            val vm: HomeViewModel = hiltViewModel()
            HomeRoute(
                homeViewModel = vm,
                navigateToDetail = navigationActions.navigationToDetailCharacter
            )
        }

        composable(
            route = AMGMarvelDestinations.CHARACTER_DETAIL_ROUTE,
//            arguments = listOf(navArgument("characterId") {
//                type = NavType.LongType
//                defaultValue = 4L
//            })
        ) {
            val vm: CharacterViewModel = hiltViewModel()
            CharacterRoute(characterViewModel = vm)
        }
    }
}