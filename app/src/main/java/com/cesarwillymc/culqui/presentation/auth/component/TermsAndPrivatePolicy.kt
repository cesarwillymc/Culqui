package com.cesarwillymc.culqui.presentation.auth.component

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.cesarwillymc.culqui.R

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
private const val TERMS_TAG = "terms"
private const val POLICY_TAG = "policy"

@Composable
fun TermsAndPrivatePolicy(
    onPolicyClicked: (String) -> Unit,
    onTermsClicked: (String) -> Unit
) {
    val annotatedString = getAnnotatedString()
    ClickableText(
        text = annotatedString,
        modifier = Modifier,
        style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.background),
        onClick = { offset ->
            annotatedString.getStringAnnotations(tag = POLICY_TAG, start = offset, end = offset)
                .firstOrNull()?.let {
                    onPolicyClicked(it.item)
                }

            annotatedString.getStringAnnotations(tag = TERMS_TAG, start = offset, end = offset)
                .firstOrNull()?.let {
                    onTermsClicked(it.item)
                }
        }
    )
}

@Composable
fun getAnnotatedString() = buildAnnotatedString {
    append(stringResource(R.string.desc_terms_conditions))
    pushStringAnnotation(
        tag = TERMS_TAG,
        annotation = stringResource(R.string.lbl_url)
    )
    withStyle(
        style = SpanStyle(
            color = MaterialTheme.colorScheme.primary,
            fontSize = TextUnit(dimensionResource(id = R.dimen.TextNormal).value, TextUnitType.Sp),
            fontWeight = FontWeight.Bold
        )
    ) {
        append(stringResource(R.string.til_terms_service))
    }
    pop()
    append(stringResource(R.string.lbl_and))
    pushStringAnnotation(
        tag = POLICY_TAG,
        annotation = stringResource(R.string.lbl_url)
    )
    withStyle(
        style = SpanStyle(
            color = MaterialTheme.colorScheme.primary,
            fontSize = TextUnit(dimensionResource(id = R.dimen.TextNormal).value, TextUnitType.Sp),
            fontWeight = FontWeight.Bold
        )
    ) {
        append(stringResource(R.string.lbl_privacy_policy))
    }
    pop()
}
