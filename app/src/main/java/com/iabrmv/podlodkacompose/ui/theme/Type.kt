package com.iabrmv.podlodkacompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.iabrmv.podlodkacompose.R


val skModernistFamily = FontFamily(
    Font(R.font.sk_modernist_regular, FontWeight.Normal),
    Font(R.font.sk_modernist_bold, FontWeight.Bold),
    Font(R.font.sk_modernist_mono, FontWeight.Medium)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = skModernistFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)
