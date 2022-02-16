package com.iabrmv.podlodkacompose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun RatingBar(
    rating: Float,
    activeColor: Color = MaterialTheme.colors.secondary,
    inactiveColor: Color = MaterialTheme.colors.background
) {
    Row {
        for(i in 1..5) {
            Star(
                modifier = Modifier.padding(4.dp),
                starState = StarState.computeState(rating, i),
                inactiveColor = inactiveColor,
                activeColor = activeColor
            )
        }
    }
}

@Composable
fun Star(
    modifier : Modifier,
    starState: StarState,
    activeColor: Color,
    inactiveColor: Color
) {
    when(starState) {
        StarState.Whole -> Icon(
            modifier = modifier,
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = null,
            tint = activeColor
        )
        StarState.Half -> {
            Box(modifier = modifier) {
                Icon(
                    modifier = Modifier.scale(scaleX = -1f, scaleY = 1f),
                    painter = painterResource(id = R.drawable.ic_star_half),
                    contentDescription = null,
                    tint = inactiveColor
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_star_half),
                    contentDescription = null,
                    tint = activeColor
                )
            }
        }
        StarState.Empty -> Icon(
            modifier = modifier,
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = null,
            tint = inactiveColor
        )
    }
}

enum class StarState {
    Empty,
    Half,
    Whole;

    companion object {
        fun computeState(
            rating: Float,
            number: Int
        ): StarState = when(number - rating) {
            in -4f..0.25f -> Whole
            in 0.25f..0.75f -> Half
            in 0.75f..4f -> Empty
            else -> Empty
        }
    }
}