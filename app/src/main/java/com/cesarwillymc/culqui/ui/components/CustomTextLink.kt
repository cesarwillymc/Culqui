package com.cesarwillymc.culqui.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.cesarwillymc.culqui.R

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun CustomTextLink(
    title: String,
    onClick: () -> Unit,
    textColor: Color = MaterialTheme.colorScheme.primary
) {
    Text(
        text = title,
        style = MaterialTheme.typography.bodyMedium,
        color = textColor,
        fontWeight = FontWeight.ExtraBold,
        modifier = Modifier.clickable(onClick = onClick)
    )
}

@Composable
@Preview(name = "Light Theme", showBackground = true)
fun CustomTextLinkPreview() {
    CustomTextLink(
        title = stringResource(R.string.lbl_forgot_password),
        onClick = {}
    )
}
