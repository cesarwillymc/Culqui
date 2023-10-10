package com.cesarwillymc.culqui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.cesarwillymc.culqui.ui.components.CustomFullScreenLoading
import com.cesarwillymc.culqui.ui.navigation.graph.CustomNavGraph
import com.cesarwillymc.culqui.ui.theme.CulquiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CulquiTheme {
                val startDestination by mainViewModel.startDestination.collectAsState()
                val navController = rememberNavController()

                CustomFullScreenLoading(startDestination.isNullOrBlank())
                if (!startDestination.isNullOrBlank()) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        CustomNavGraph(
                            navController = navController,
                            startDestination = startDestination.orEmpty()
                        )
                    }
                }
            }
        }
    }
}