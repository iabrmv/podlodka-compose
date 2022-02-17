package com.iabrmv.podlodkacompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iabrmv.podlodkacompose.data.ReviewData


@Composable
fun ReviewItem(
    modifier: Modifier = Modifier,
    review: ReviewData
) {
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier.size(48.dp),
                painter = painterResource(id = review.imageResource),
                contentDescription = null
            )
            Column(modifier.padding(horizontal = 4.dp)) {
                Text(review.name, color = MaterialTheme.colors.onBackground, fontSize = 20.sp)
                Text(review.datePosted, color = MaterialTheme.colors.onSurface)
            }
        }
        Text(review.text, color = MaterialTheme.colors.onSurface)
        Spacer(Modifier.height(20.dp))
        Divider(
            Modifier
                .height(1.dp)
                .fillMaxWidth())
    }
}

