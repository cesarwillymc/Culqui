package com.cesarwillymc.culqui.presentation.auth.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.cesarwillymc.culqui.R
import com.cesarwillymc.culqui.util.constants.ALPHA_BACKGROUND

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun ShapeContent(
    content: @Composable ColumnScope.() -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.background
) {
    Column(
        modifier = modifier
            .background(
                backgroundColor.copy(alpha = ALPHA_BACKGROUND),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.Small150))
            )
            .padding(dimensionResource(id = R.dimen.Normal100)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.Normal100))
    ) {
        content()
    }
}

@Composable
@Preview(name = "Light Theme", showBackground = true)
fun ShapeContentPreview() {
    ShapeContent(
        content = {
            Text(text = "Hola")
        },
        backgroundColor = Color.Black
    )
}
