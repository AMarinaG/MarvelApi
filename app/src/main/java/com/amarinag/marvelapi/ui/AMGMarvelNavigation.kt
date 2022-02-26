package com.amarinag.marvelapi.ui

import androidx.navigation.NavController

object AMGMarvelDestinations {
    const val HOME_ROUTE = "home"
    const val CHARACTER_DETAIL_ROUTE = "character"
}

class AMGNavigationActions(navController: NavController) {
    val navigationToDetailCharacter: (Long) -> Unit = {
        navController.navigate("${AMGMarvelDestinations.CHARACTER_DETAIL_ROUTE}/$it")
    }
}