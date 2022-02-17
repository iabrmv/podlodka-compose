package com.iabrmv.podlodkacompose.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val ColorPalette = lightColors(
    primary = LightBlue,
    secondary = Yellow,
    background = DarkBlue,
    surface = DarkTextColor,
    onBackground = Color.White,
    onSurface = SecondaryTextColor
)

@Composable
fun PodlodkaComposeTheme(
    content: @Composable () -> Unit
) {
    val colors = ColorPalette
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}