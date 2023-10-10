package com.cesarwillymc.culqui.presentation.auth.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.cesarwillymc.culqui.R
import com.cesarwillymc.culqui.ui.components.CustomPrimaryButton

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun ColumnScope.AuthButtonContent(
    onclickFacebook: () -> Unit,
    onclickApple: () -> Unit,
    onclickGoogle: () -> Unit
) {
    CustomPrimaryButton(
        title = stringResource(R.string.lbl_facebook),
        textColor = MaterialTheme.colorScheme.onBackground,
        backGroundColor = MaterialTheme.colorScheme.background,
        leadingIcon = R.drawable.ic_facebook,
        onClick = onclickFacebook
    )
    CustomPrimaryButton(
        title = stringResource(R.string.lbl_google),
        textColor = MaterialTheme.colorScheme.onBackground,
        backGroundColor = MaterialTheme.colorScheme.background,
        leadingIcon = R.drawable.ic_google,
        onClick = onclickGoogle
    )
    CustomPrimaryButton(
        title = stringResource(R.string.lbl_apple),
        textColor = MaterialTheme.colorScheme.onBackground,
        backGroundColor = MaterialTheme.colorScheme.background,
        leadingIcon = R.drawable.ic_apple,
        onClick = onclickApple
    )
}
