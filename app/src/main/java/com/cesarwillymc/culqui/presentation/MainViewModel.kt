package com.cesarwillymc.culqui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesarwillymc.culqui.domain.usecase.GetLoggedStateUseCase
import com.cesarwillymc.culqui.ui.navigation.route.AuthRoute
import com.cesarwillymc.culqui.ui.navigation.route.MainRoute
import com.cesarwillymc.culqui.util.constants.DELAY_700
import com.cesarwillymc.culqui.util.extension.orEmpty
import com.cesarwillymc.culqui.util.state.dataOrNull
import com.cesarwillymc.culqui.util.state.isSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val isLogged: GetLoggedStateUseCase
) : ViewModel() {
    private val _startDestination = MutableStateFlow<String?>(null)
    val startDestination get() = _startDestination

    init {
        loadMainRoute()
    }

    fun loadMainRoute() {
        viewModelScope.launch {
            delay(DELAY_700)
            isLogged(Unit).let { result ->
                if(result.isSuccess && result.dataOrNull().orEmpty()){
                    _startDestination.update { MainRoute.Main.path }
                }else{
                    _startDestination.update { AuthRoute.Auth.path }
                }
            }
        }
    }
}
