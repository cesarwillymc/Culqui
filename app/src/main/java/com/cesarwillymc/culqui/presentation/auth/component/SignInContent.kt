package com.cesarwillymc.culqui.presentation.auth.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cesarwillymc.culqui.R
import com.cesarwillymc.culqui.ui.components.CustomPrimaryButton
import com.cesarwillymc.culqui.ui.components.CustomTextField
import com.cesarwillymc.culqui.ui.components.CustomTextLink
import com.cesarwillymc.culqui.ui.validations.field.PasswordField

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun ColumnScope.SignInContent(
    passwordField: PasswordField,
    onContinue: () -> Unit,
    onClickForgotPassword: () -> Unit,
    emailText: String
) {
    val isErrorPassword by passwordField.isError.collectAsState()
    ProfileCard(
        picture = "https://reqres.in/img/faces/8-image.jpg",
        name = "Jane Doe",
        email = emailText
    )
    CustomTextField(
        query = passwordField.text.collectAsState().value,
        onQueryChange = passwordField::setText,
        hintText = stringResource(R.string.lbl_password),
        isError = isErrorPassword,
        isTypePassword = true,
    )
    CustomPrimaryButton(
        title = stringResource(R.string.lbl_continue),
        textColor = MaterialTheme.colorScheme.background,
        onClick = onContinue
    )
    Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.Small100)))
    CustomTextLink(
        title = stringResource(R.string.lbl_forgot_password),
        onClick = onClickForgotPassword
    )
}

@Composable
@Preview(name = "Light Theme", showBackground = true)
fun SignInContentPreview() {
    AuthScaffold(
        title = stringResource(R.string.title_welcome),
        isBackEnabled = true,
        content = {
            SignInContent(PasswordField(), {}, {}, "emailText")
        }
    )
}
