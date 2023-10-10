package com.cesarwillymc.culqui.presentation.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.cesarwillymc.culqui.R
import com.cesarwillymc.culqui.presentation.auth.component.AuthScaffold
import com.cesarwillymc.culqui.presentation.auth.component.SignInContent
import com.cesarwillymc.culqui.presentation.auth.viewmodel.SignInViewModel

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun SignInScreen(
    navigateUp: () -> Unit,
    signInViewModel: SignInViewModel
) {
    val passwordField = signInViewModel.passwordText
    val emailText by signInViewModel.emailText.collectAsState()
    AuthScaffold(
        title = stringResource(id = R.string.til_sign_in),
        isBackEnabled = true,
        onNavigateUp = navigateUp
    ) {
        SignInContent(
            emailText = emailText,
            passwordField = passwordField,
            onContinue = {},
            onClickForgotPassword = {
                // todo
            }
        )
    }
}