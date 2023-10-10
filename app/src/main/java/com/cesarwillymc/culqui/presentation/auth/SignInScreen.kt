package com.cesarwillymc.culqui.presentation.auth

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.cesarwillymc.culqui.R
import com.cesarwillymc.culqui.presentation.auth.component.AuthScaffold
import com.cesarwillymc.culqui.presentation.auth.component.SignInContent
import com.cesarwillymc.culqui.presentation.auth.viewmodel.SignInViewModel
import com.cesarwillymc.culqui.ui.components.CustomFullScreenLoading
import com.cesarwillymc.culqui.ui.components.CustomSnackbar

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun SignInScreen(
    navigateUp: () -> Unit,
    navigateHome: () -> Unit,
    signInViewModel: SignInViewModel
) {
    val passwordField = signInViewModel.passwordText
    val emailText by signInViewModel.emailText.collectAsState()
    val authUiState by signInViewModel.authUiState.collectAsState()
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    CustomFullScreenLoading(authUiState.isLoading)
    AuthScaffold(
        title = stringResource(id = R.string.til_sign_in),
        isBackEnabled = true,
        onNavigateUp = navigateUp
    ) {
        SignInContent(
            emailText = emailText,
            passwordField = passwordField,
            onContinue = signInViewModel::login,
            onClickForgotPassword = {
                // todo
            }
        )
    }
    CustomSnackbar(snackbarHostState = snackbarHostState)
    LaunchedEffect(authUiState) {
        if (authUiState.isError) {
            snackbarHostState.showSnackbar(
                message = authUiState.errorMessage
                    ?: context.getString(R.string.desc_error_snackbar),
                actionLabel = context.getString(R.string.lbl_error),
                duration = SnackbarDuration.Long,
                withDismissAction = true
            )
        }
        if (authUiState.isSuccess) {
            navigateHome()
        }
    }

}