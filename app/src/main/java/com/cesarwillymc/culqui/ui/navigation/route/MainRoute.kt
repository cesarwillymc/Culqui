package com.cesarwillymc.culqui.ui.navigation.route

sealed class MainRoute(path: String) : Route(path) {
    object Main : MainRoute(MAIN_ROUTE)
    companion object {
        const val MAIN_ROUTE = "home"
    }
}
