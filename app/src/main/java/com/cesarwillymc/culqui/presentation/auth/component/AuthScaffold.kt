package com.cesarwillymc.culqui.presentation.auth.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.cesarwillymc.culqui.R
import com.cesarwillymc.culqui.util.constants.FRACTION_20
import com.cesarwillymc.culqui.util.extension.rememberResponsive

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun AuthScaffold(
    title: String,
    isBackEnabled: Boolean = false,
    onNavigateUp: () -> Unit = {},
    content: @Composable ColumnScope.() -> Unit
) {
    val responsive = rememberResponsive()
    Scaffold { paddingValues ->
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = stringResource(R.string.lbl_onbackground),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .padding(dimensionResource(id = R.dimen.Normal100))
                .fillMaxSize()
        ) {
            if (isBackEnabled) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = stringResource(id = R.string.desc_back),
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .clickable(onClick = onNavigateUp),
                    tint = Color.White
                )
            }

            Column(
                modifier = Modifier
                    .offset(y = responsive.heightR(FRACTION_20))
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = dimensionResource(id = R.dimen.Normal100))
                )
                Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.Large100)))
                ShapeContent(content = content, backgroundColor = Color.Black)
            }
        }
    }
}

@Composable
@Preview(name = "Light Theme", showBackground = true)
fun AuthScaffoldPreview() {
    AuthScaffold(
        title = stringResource(R.string.title_welcome),
        isBackEnabled = true,
        content = {
            AuthButtonContent({}, {}, {})
        }
    )
}
