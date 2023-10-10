package com.cesarwillymc.culqui.presentation.auth.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.cesarwillymc.culqui.ui.navigation.route.AuthRoute.Companion.EMAIL_KEY
import com.cesarwillymc.culqui.ui.validations.field.EmailField
import com.cesarwillymc.culqui.ui.validations.field.PasswordField
import com.cesarwillymc.culqui.util.constants.EMPTY_STRING
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@HiltViewModel
class SignInViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val passwordText  = PasswordField()
    val emailText get() = savedStateHandle.getStateFlow(EMAIL_KEY, EMPTY_STRING)
}