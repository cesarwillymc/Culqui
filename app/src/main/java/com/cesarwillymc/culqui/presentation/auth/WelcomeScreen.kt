package com.cesarwillymc.culqui.presentation.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.cesarwillymc.culqui.R
import com.cesarwillymc.culqui.presentation.auth.component.AuthScaffold
import com.cesarwillymc.culqui.presentation.auth.component.WelcomeContent
import com.cesarwillymc.culqui.presentation.auth.viewmodel.WelcomeViewModel
import com.cesarwillymc.culqui.ui.navigation.action.AuthAction

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun WelcomeScreen(
    authAction: AuthAction,
    welcomeViewModel: WelcomeViewModel
) {
    val emailField = welcomeViewModel.emailText
    AuthScaffold(
        title = stringResource(id = R.string.title_welcome),
        isBackEnabled = false,
    ) {
        WelcomeContent(
            emailField = emailField,
            onClickApple = {
                // Todo
            },
            onClickFacebook = {
                // Todo
            },
            onClickForgotPassword = {
                // Todo
            },
            onClickGoogle = {
                // Todo
            },
            onClickSignUp = authAction.navigateToSignUp,
            onContinueEmail = authAction.navigateToSignIn
        )
    }
}