package com.cesarwillymc.culqui.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesarwillymc.culqui.domain.usecase.LogoutUseCase
import com.cesarwillymc.culqui.presentation.auth.state.AuthUiState
import com.cesarwillymc.culqui.util.state.isError
import com.cesarwillymc.culqui.util.state.isSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase
) : ViewModel() {
    val authUiState get() = _authUiState
    private val _authUiState = MutableStateFlow(AuthUiState())
    fun logout() {
        authUiState.update { AuthUiState(isLoading = true) }
        viewModelScope.launch {
            logoutUseCase(Unit).let { result ->
                when {
                    result.isSuccess -> {
                        authUiState.update { AuthUiState(isSuccess = true) }
                    }

                    result.isError -> {
                        authUiState.update { AuthUiState(isError = true) }
                    }
                }
            }
        }
    }
}
