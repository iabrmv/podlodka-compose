package com.iabrmv.podlodkacompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Header(
    modifier: Modifier = Modifier,
    name: String,
    appIconResource: Int,
    rating: Float,
    reviewsCountString: String
) {
    Row(modifier = modifier.fillMaxWidth()) {
        Box(modifier = Modifier
            .size(96.dp)
            .offset(y = (-32).dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = Color.Black)
            .border(
                width = 2.dp,
                color = MaterialTheme.colors.onSurface,
                shape = RoundedCornerShape(10.dp)
            )
            .clip(shape = RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = appIconResource),
                contentDescription = null
            )
        }
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = name,
                fontSize = 32.sp,
                color = MaterialTheme.colors.onBackground
            )
            Row {
                RatingBar(rating)
                Text(
                    text = reviewsCountString,
                    color = MaterialTheme.colors.onSurface
                )
            }
        }
    }
}