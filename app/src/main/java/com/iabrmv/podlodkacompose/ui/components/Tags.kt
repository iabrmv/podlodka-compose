package com.iabrmv.podlodkacompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp

@Composable
fun Tags(
    modifier: Modifier = Modifier,
    tags: List<String>
) {
    LazyRow(modifier = modifier) {
        items(tags) {
            Tag(it)
            Spacer(Modifier.size(8.dp))
        }
    }
}


@Composable
fun Tag(tag: String) {
    Text(
        modifier = Modifier
            .wrapContentSize()
            .background(
                alpha = 0.3f,
                brush = SolidColor(MaterialTheme.colors.primary),
                shape = CircleShape
            )
            .padding(vertical = 4.dp, horizontal = 8.dp),
        text = tag,
        color = MaterialTheme.colors.primary
    )
}