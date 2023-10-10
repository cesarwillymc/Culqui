package com.cesarwillymc.culqui.presentation.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.cesarwillymc.culqui.R
import com.cesarwillymc.culqui.presentation.auth.component.AuthScaffold
import com.cesarwillymc.culqui.presentation.auth.component.SignUpContent
import com.cesarwillymc.culqui.presentation.auth.viewmodel.SignUpViewModel

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun SignUpScreen(
    navigateUp: () -> Unit,
    signUpViewModel: SignUpViewModel
) {
    val passwordField = signUpViewModel.passwordText
    val nameField = signUpViewModel.nameText
    AuthScaffold(
        title = stringResource(id = R.string.til_sign_up),
        isBackEnabled = true,
        onNavigateUp = navigateUp
    ) {
        SignUpContent(
            nameField = nameField,
            passwordField = passwordField,
            onContinueEmail = {},
            onPolicyClicked = {
                // todo
            },
            onTermsClicked = {
                // todo
            }
        )
    }
}