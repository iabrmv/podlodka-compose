package com.iabrmv.podlodkacompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun BackgroundImage(
    modifier: Modifier = Modifier,
    imageResource: Int
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = imageResource),
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )
}