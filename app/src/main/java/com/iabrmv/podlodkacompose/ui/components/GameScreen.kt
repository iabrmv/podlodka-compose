package com.iabrmv.podlodkacompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import com.iabrmv.podlodkacompose.data.ReviewData

@Composable
fun GameScreen(
    appName: String,
    backgroundImageResource: Int,
    appIconResource: Int,
    rating: Float,
    tags: List<String>,
    description: String,
    screenshotResources: List<Int>,
    reviews: List<ReviewData>,
    reviewsCountString: String,
) {
    val backGroundImageHeight = 250.dp
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        BackgroundImage(
            modifier = Modifier
                .height(backGroundImageHeight)
                .scale(2f)
                .align(Alignment.TopCenter),
            imageResource = backgroundImageResource
        )
        LazyColumn {
            item {
                Row(
                    modifier = Modifier
                        .height(backGroundImageHeight)
                        .fillMaxWidth()
                        .padding(32.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CircleButton(
                        modifier = Modifier.size(48.dp),
                        imageVector = Icons.Filled.ArrowBack
                    )
                    CircleButton(
                        modifier = Modifier.size(48.dp),
                        imageVector = Icons.Filled.MoreHoriz
                    )
                }
            }
            item {
                Column(
                    Modifier
                        .background(
                            color = MaterialTheme.colors.background,
                            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                        )
                        .padding(horizontal = 12.dp)
                ) {
                    Header(
                        modifier = Modifier
                            .padding(12.dp),
                        name = appName,
                        appIconResource = appIconResource,
                        rating = rating,
                        reviewsCountString = reviewsCountString
                    )
                    Tags(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp)
                            .wrapContentHeight(),
                        tags = tags
                    )
                    Description(
                        modifier = Modifier
                            .background(color = MaterialTheme.colors.background)
                            .padding(vertical = 12.dp),
                        text = description
                    )
                    Videos(
                        screenshotResources = screenshotResources,
                        modifier = Modifier
                            .background(color = MaterialTheme.colors.background)
                            .padding(vertical = 12.dp)
                            .height(120.dp)
                    )
                    Rating(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = MaterialTheme.colors.background)
                            .padding(vertical = 12.dp),
                        rating = rating,
                        reviewsCountString = reviewsCountString
                    )
                }
            }
            items(reviews) { review ->
                ReviewItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colors.background)
                        .padding(12.dp),
                    review = review
                )
            }
            item {
                Spacer(Modifier.height(120.dp))
            }
        }
        InstallButton(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxWidth()
                .padding(30.dp)
                .align(Alignment.BottomCenter)
        )
    }
}