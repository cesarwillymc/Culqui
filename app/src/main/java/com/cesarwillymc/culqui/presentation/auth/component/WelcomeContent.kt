package com.cesarwillymc.culqui.presentation.auth.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.cesarwillymc.culqui.R
import com.cesarwillymc.culqui.ui.components.CustomPrimaryButton
import com.cesarwillymc.culqui.ui.components.CustomTextField
import com.cesarwillymc.culqui.ui.components.CustomTextLink
import com.cesarwillymc.culqui.ui.validations.field.EmailField

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun ColumnScope.WelcomeContent(
    emailField: EmailField,
    onContinueEmail: (String) -> Unit,
    onClickFacebook: () -> Unit,
    onClickApple: () -> Unit,
    onClickGoogle: () -> Unit,
    onClickForgotPassword: () -> Unit,
    onClickSignUp: () -> Unit
) {
    val isErrorEmail by emailField.isError.collectAsState()
    CustomTextField(
        query = emailField.text.collectAsState().value,
        onQueryChange = emailField::setText,
        keyboardType = KeyboardType.Email,
        hintText = stringResource(R.string.lbl_email),
        isError = emailField.isError.collectAsState().value
    )
    CustomPrimaryButton(
        title = stringResource(R.string.lbl_continue),
        textColor = MaterialTheme.colorScheme.background,
        onClick = { onContinueEmail(emailField.text.value) },
        isEnabled = !isErrorEmail
    )
    Text(
        text = stringResource(R.string.lbl_or),
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.background,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
    AuthButtonContent(
        onclickFacebook = onClickFacebook,
        onclickApple = onClickApple,
        onclickGoogle = onClickGoogle
    )
    Row {
        Text(
            text = stringResource(R.string.lbl_no_account),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
        Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.Normal100)))
        CustomTextLink(
            title = stringResource(R.string.til_sign_up),
            onClick = onClickSignUp
        )
    }
    CustomTextLink(
        title = stringResource(R.string.lbl_forgot_password),
        onClick = onClickForgotPassword
    )
}

@Composable
@Preview(name = "Light Theme", showBackground = true)
fun WelcomeContentPreview() {
    AuthScaffold(
        title = stringResource(R.string.title_welcome),
        isBackEnabled = true,
        content = {
            WelcomeContent(EmailField(), {}, {}, {}, {}, {}, {})
        }
    )
}
