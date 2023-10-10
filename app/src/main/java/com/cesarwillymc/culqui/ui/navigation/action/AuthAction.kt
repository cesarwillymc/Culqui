package com.cesarwillymc.culqui.ui.navigation.action

import androidx.navigation.NavHostController
import com.cesarwillymc.culqui.ui.navigation.route.AuthRoute

class AuthAction(navController: NavHostController) {

    val navigateToAuth: () -> Unit = {
        navController.navigate(AuthRoute.Auth.path) {
            popUpTo(AuthRoute.Auth.path) { inclusive = true }
        }
    }
    val navigateToSignIn: (String) -> Unit = {
        navController.navigate(
            AuthRoute.SignIn.path.replace(
                "{${AuthRoute.EMAIL_KEY}}",
                it
            )
        )
    }
    val navigateToSignUp: () -> Unit = {
        navController.navigate(AuthRoute.SignUp.path)
    }
}
