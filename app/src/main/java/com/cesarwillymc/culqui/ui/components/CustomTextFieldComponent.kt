package com.cesarwillymc.culqui.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.cesarwillymc.culqui.R
import com.cesarwillymc.culqui.util.constants.EMPTY_STRING
import com.cesarwillymc.culqui.util.constants.ONE

/**
 * Created by Cesar Canaza on 10/3/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */

/** TextFieldValue control the cursor position **/
@SuppressWarnings("LongMethod")
@Composable
fun CustomTextField(
    query: String,
    onQueryChange: (String) -> Unit,
    onGoClicked: () -> Unit = {},
    hintText: String = EMPTY_STRING,
    isTypePassword: Boolean = false,
    isError: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    var isFocused by remember { mutableStateOf(false) }
    val keyboardController = LocalTextInputService.current
    var isHideText by remember { mutableStateOf(true) }


    BasicTextField(
        value = query,
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.Large175))
            .onFocusChanged {
                isFocused = it.isFocused
            }
            .background(
                MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.Small150))
            )
            .border(
                width = dimensionResource(id = R.dimen.OneDp),
                color = when {
                    query.isNotBlank() && !isError ->  MaterialTheme.colorScheme.primary
                    query.isBlank()  ->   MaterialTheme.colorScheme.inversePrimary
                    else -> Color.Red
                },
                RoundedCornerShape(dimensionResource(id = R.dimen.Small150))
            ),
        onValueChange = onQueryChange,
        textStyle = MaterialTheme.typography.bodyMedium,
        maxLines = ONE,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Go
        ),
        keyboardActions = KeyboardActions(
            onGo = {
                keyboardController?.hideSoftwareKeyboard()
                onGoClicked()
            }
        ),
        visualTransformation = if (isHideText && isTypePassword) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        decorationBox = { innerTextField ->
            ConstraintLayout {
                val (lblText, trailingIcon) = createRefs()
                Box(modifier = Modifier
                    .constrainAs(lblText) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(
                            if (isTypePassword) {
                                trailingIcon.start
                            } else {
                                parent.end
                            }
                        )
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }) {
                    Box(
                        modifier = Modifier
                            .padding(dimensionResource(id = R.dimen.Small100))
                            .align(
                                Alignment.CenterStart
                            )
                    ) {
                        innerTextField()
                    }


                    if (hintText.isNotEmpty()) {
                        Text(
                            text = hintText,
                            style = if (isFocused) {
                                MaterialTheme.typography.bodySmall
                            } else {
                                MaterialTheme.typography.bodyMedium
                            },
                            modifier = Modifier
                                .align(
                                    if (isFocused || query.isNotBlank()) {
                                        Alignment.TopStart
                                    } else {
                                        Alignment.CenterStart
                                    }
                                )
                                .padding(start = dimensionResource(id = R.dimen.Small100))
                        )
                    }
                }
                if (isTypePassword) {

                    Text(
                        text = if (isHideText) {
                            stringResource(R.string.lbl_view)
                        } else {
                            stringResource(R.string.lbl_hide)

                        },
                        modifier = Modifier
                            .constrainAs(trailingIcon) {
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                                end.linkTo(
                                    parent.end
                                )
                            }
                            .padding(end = dimensionResource(id = R.dimen.Small150))
                            .clickable {
                                isHideText = !isHideText
                            }
                    )

                }
            }

        }
    )
}

@Composable
@Preview(name = "Light Theme", showBackground = true)
fun CustomSearchViewComponentPreview() {
    CustomTextField(
        query = "hola",
        onQueryChange = {},
        onGoClicked = {},
        isTypePassword = false
    )
}
