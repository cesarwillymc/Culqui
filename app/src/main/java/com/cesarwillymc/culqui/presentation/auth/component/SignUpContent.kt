package com.cesarwillymc.culqui.presentation.auth.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.cesarwillymc.culqui.R
import com.cesarwillymc.culqui.ui.components.CustomPrimaryButton
import com.cesarwillymc.culqui.ui.components.CustomTextField
import com.cesarwillymc.culqui.ui.components.CustomTextLink
import com.cesarwillymc.culqui.ui.validations.field.EmailField
import com.cesarwillymc.culqui.ui.validations.field.NameField
import com.cesarwillymc.culqui.ui.validations.field.PasswordField

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun ColumnScope.SignUpContent(
    nameField: NameField,
    passwordField: PasswordField,
    onContinueEmail: () -> Unit,
    onPolicyClicked: (String) -> Unit,
    onTermsClicked: (String) -> Unit
) {
    val isErrorNameField by nameField.isError.collectAsState()
    val isErrorPasswordField by passwordField.isError.collectAsState()
    Text(
        text = stringResource(R.string.lbl_create_account),
        style = MaterialTheme.typography.bodyMedium,
        color = Color.White
    )
    Text(
        text = stringResource(R.string.lbl_email_example),
        style = MaterialTheme.typography.bodyMedium,
        color = Color.White,
        fontWeight = FontWeight.Bold
    )
    CustomTextField(
        query = nameField.text.collectAsState().value,
        onQueryChange = nameField::setText,
        keyboardType = KeyboardType.Email,
        hintText = stringResource(R.string.lbl_name),
        isError =  isErrorNameField
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
        isEnabled = !isErrorNameField && !isErrorPasswordField
    )
}

@Composable
@Preview(name = "Light Theme", showBackground = true)
fun SignUpContentPreview() {
    AuthScaffold(
        title = stringResource(R.string.title_welcome),
        isBackEnabled = true,
        content = {
            SignUpContent(NameField(), PasswordField(),{},{},{})
        }
    )
}
