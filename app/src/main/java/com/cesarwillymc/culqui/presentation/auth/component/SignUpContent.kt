package com.cesarwillymc.culqui.presentation.auth.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.cesarwillymc.culqui.R
import com.cesarwillymc.culqui.ui.components.CustomPrimaryButton
import com.cesarwillymc.culqui.ui.components.CustomTextField
import com.cesarwillymc.culqui.ui.validations.field.EmailField
import com.cesarwillymc.culqui.ui.validations.field.PasswordField

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun ColumnScope.SignUpContent(
    emailField: EmailField,
    passwordField: PasswordField,
    onContinueEmail: () -> Unit,
    onPolicyClicked: (String) -> Unit,
    onTermsClicked: (String) -> Unit
) {
    val isErrorEmailField by emailField.isError.collectAsState()
    val isErrorPasswordField by passwordField.isError.collectAsState()
    Text(
        text = stringResource(R.string.lbl_create_account),
        style = MaterialTheme.typography.bodyMedium,
        color = Color.White
    )
    CustomTextField(
        query = emailField.text.collectAsState().value,
        onQueryChange = emailField::setText,
        keyboardType = KeyboardType.Email,
        hintText = stringResource(R.string.lbl_email),
        isError =  isErrorEmailField
    )
    CustomTextField(
        query = passwordField.text.collectAsState().value,
        onQueryChange = passwordField::setText,
        keyboardType = KeyboardType.Text,
        hintText = stringResource(R.string.lbl_password),
        isError = isErrorPasswordField
    )

    TermsAndPrivatePolicy(
        onPolicyClicked = onPolicyClicked,
        onTermsClicked = onTermsClicked
    )
    CustomPrimaryButton(
        title = stringResource(R.string.lbl_agree_and_continue),
        textColor = MaterialTheme.colorScheme.background,
        onClick = onContinueEmail,
        isEnabled = !isErrorEmailField && !isErrorPasswordField
    )
}

@Composable
@Preview(name = "Light Theme", showBackground = true)
fun SignUpContentPreview() {
    AuthScaffold(
        title = stringResource(R.string.title_welcome),
        isBackEnabled = true,
        content = {
            SignUpContent(EmailField(), PasswordField(),{},{},{})
        }
    )
}
