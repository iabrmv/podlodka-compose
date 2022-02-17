package com.iabrmv.podlodkacompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun Videos(
    modifier: Modifier = Modifier,
    screenshotResources: List<Int>
) {
    LazyRow(modifier = modifier) {
        items(screenshotResources) { screenshotResource ->
            Video(screenshotResource)
            Spacer(Modifier.width(20.dp))
        }
    }
}

@Composable
fun Video(screenshotResource: Int) {
    Box(contentAlignment = Alignment.Center) {
        Image(
            modifier = Modifier.clip(RoundedCornerShape(16.dp)),
            painter = painterResource(id = screenshotResource),
            contentDescription = null
        )
        CircleButton(
            modifier = Modifier.size(36.dp),
            imageVector = Icons.Filled.PlayArrow
        )
    }
}