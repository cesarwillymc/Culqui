package com.cesarwillymc.culqui.ui.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.cesarwillymc.culqui.presentation.auth.SignInScreen
import com.cesarwillymc.culqui.presentation.auth.SignUpScreen
import com.cesarwillymc.culqui.presentation.auth.WelcomeScreen
import com.cesarwillymc.culqui.presentation.home.HomeScreen
import com.cesarwillymc.culqui.ui.navigation.action.AuthAction
import com.cesarwillymc.culqui.ui.navigation.action.MainAction
import com.cesarwillymc.culqui.ui.navigation.deeplink.generateDeepLinks
import com.cesarwillymc.culqui.ui.navigation.route.AuthRoute
import com.cesarwillymc.culqui.ui.navigation.route.MainRoute

@Composable
fun CustomNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    val mainActions = remember(navController) { MainAction(navController) }
    val authActions = remember(navController) { AuthAction(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        navigation(startDestination = AuthRoute.Welcome.path, route = AuthRoute.Auth.path) {
            composable(
                route = AuthRoute.Welcome.path,
                deepLinks = AuthRoute.Welcome.path.generateDeepLinks()
            ) {
                WelcomeScreen(
                    authAction = authActions,
                    welcomeViewModel = hiltViewModel()
                )
            }
            composable(
                route = AuthRoute.SignIn.path,
                deepLinks = AuthRoute.SignIn.path.generateDeepLinks()
            ) {
                SignInScreen(
                    navigateUp = mainActions.navigateUp,
                    signInViewModel = hiltViewModel(),
                    navigateHome = mainActions.navigateToMain
                )
            }
            composable(
                route = AuthRoute.SignUp.path,
                deepLinks = AuthRoute.SignUp.path.generateDeepLinks()
            ) {
                SignUpScreen(
                    navigateUp = mainActions.navigateUp,
                    signUpViewModel = hiltViewModel(),
                    navigateHome = mainActions.navigateToMain
                )
            }
        }

        composable(
            route = MainRoute.Main.path,
            deepLinks = MainRoute.Main.path.generateDeepLinks()
        ) {
            HomeScreen(
                homeViewModel = hiltViewModel(),
                navigateAuthScreen = authActions.navigateToAuth
            )
        }
    }
}
