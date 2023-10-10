package com.cesarwillymc.culqui.presentation.auth.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesarwillymc.culqui.data.settings.network.util.error.ErrorSource
import com.cesarwillymc.culqui.domain.usecase.SignInUseCase
import com.cesarwillymc.culqui.domain.usecase.entities.AuthParams
import com.cesarwillymc.culqui.presentation.auth.state.AuthUiState
import com.cesarwillymc.culqui.ui.navigation.route.AuthRoute.Companion.EMAIL_KEY
import com.cesarwillymc.culqui.ui.validations.field.PasswordField
import com.cesarwillymc.culqui.util.constants.EMPTY_STRING
import com.cesarwillymc.culqui.util.state.getError
import com.cesarwillymc.culqui.util.state.isError
import com.cesarwillymc.culqui.util.state.isSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@HiltViewModel
class SignInViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val signInUseCase: SignInUseCase
) : ViewModel() {
    val passwordText  = PasswordField()
    val emailText get() = savedStateHandle.getStateFlow(EMAIL_KEY, EMPTY_STRING)

    val authUiState get() = _authUiState
    private val _authUiState = MutableStateFlow(AuthUiState())
    fun login() {
        authUiState.update { AuthUiState(isLoading = true) }
        viewModelScope.launch {
            signInUseCase(
                AuthParams(
                    email = emailText.value,
                    password = passwordText.text.value
                )
            ).let { result ->
                when {
                    result.isSuccess -> {
                        authUiState.update { AuthUiState(isSuccess = true) }
                    }

                    result.isError -> {
                        var messageError: String? = result.getError().message
                        if (result.getError() is ErrorSource.ServiceError)
                            messageError = (result.getError() as ErrorSource.ServiceError).errorMessage
                        authUiState.update {
                            AuthUiState(
                                isError = true,
                                errorMessage = messageError
                            )
                        }
                    }
                }
            }
        }
    }
}