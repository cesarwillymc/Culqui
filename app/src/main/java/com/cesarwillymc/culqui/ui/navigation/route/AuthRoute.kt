package com.cesarwillymc.culqui.ui.navigation.route

sealed class AuthRoute(path: String) : Route(path) {
    object Welcome : AuthRoute(WELCOME)
    object SignIn : AuthRoute(SIGN_IN_PATH)
    object SignUp : AuthRoute(SIGN_UP_PATH)
    object Auth : AuthRoute(AUTH_ROUTE)
    companion object {
        const val EMAIL_KEY = "email"
        const val SIGN_IN_PATH = "login/{$EMAIL_KEY}"
        const val SIGN_UP_PATH = "register"
        const val WELCOME = "welcome"
        const val AUTH_ROUTE = "auth"
    }
}
