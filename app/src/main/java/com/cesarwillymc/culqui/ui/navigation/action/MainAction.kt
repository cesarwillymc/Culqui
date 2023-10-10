package com.cesarwillymc.culqui.ui.navigation.action

import androidx.navigation.NavHostController
import com.cesarwillymc.culqui.ui.navigation.route.MainRoute

class MainAction(navController: NavHostController) {

    val navigateToMain: () -> Unit = {
        navController.navigate(MainRoute.Main.path)
    }
    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}
