package com.iabrmv.podlodkacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iabrmv.podlodkacompose.ui.theme.PodlodkaComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PodlodkaComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GamePage()
                }
            }
        }
    }
}

@Composable
fun GamePage(
    appName: String = "DoTA2",
    backgroundImageResource: Int = R.drawable.header_image,
    appIconResource: Int = R.drawable.icon,
    rating: Float = 4.9f,
    tags: List<String> = listOf("MOBA", "MULTIPLAYER", "STRATEGY"),
    description: String = "Dota 2 is a multiplayer online battle arena (MOBA) game which has two teams of five players compete to collectively destroy a large structure defended by the opposing team known as the \"Ancient\", whilst defending their own.",
    screenshotResources: List<Int> = listOf(R.drawable.video1, R.drawable.video2),
    reviews: List<ReviewData> = listOf(
        ReviewData(
            imageResource = R.drawable.user1_pic,
            name = "Auguste Conte",
            datePosted = "February 14, 2019",
            text = "Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers."
        ),
        ReviewData(
            imageResource = R.drawable.user2_pic,
            name = "Jang Marcelino",
            datePosted = "February 14, 2019",
            text = "Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers."
        )
    ),
    reviewsCountString: String = "70M",
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        BackgroundImage(
            modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter),
            imageResource = backgroundImageResource
        )
        LazyColumn(Modifier.padding(20.dp)) {
            item {
                Spacer(
                    modifier = Modifier
                        .background(Color.Transparent)
                        .height(200.dp)
                        .fillMaxWidth()
                )
                Header(
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colors.background,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(12.dp),
                    name = appName,
                    appIconResource = appIconResource,
                    rating = rating
                )
            }
            item {
                Tags(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                        .wrapContentHeight(),
                    tags = tags
                )
            }
            item {
                Description(
                    modifier = Modifier.padding(12.dp),
                    text = description
                )
            }
            item {
                Videos(
                    screenshotResources = screenshotResources,
                    modifier = Modifier.padding(12.dp).height(120.dp)
                )
            }
            item {
                Rating(
                    modifier = Modifier.padding(12.dp),
                    rating = rating,
                    reviewsCountString = reviewsCountString)
            }
            items(reviews) { review ->
                ReviewItem(review)
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

@Composable
fun InstallButton(modifier: Modifier = Modifier) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
        onClick = {  }
    ) {
        Text("Install")
    }
}

@Composable
fun BackgroundImage(
    modifier: Modifier = Modifier,
    imageResource: Int
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = imageResource),
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun Header(
    modifier: Modifier = Modifier,
    name: String,
    appIconResource: Int,
    rating: Float
) {
    Row(modifier = modifier.fillMaxWidth()) {
        Box(modifier = Modifier
            .size(96.dp)
            .offset(y = (-20).dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = Color.Black)
            .border(
                width = 2.dp,
                color = MaterialTheme.colors.onSurface,
                shape = RoundedCornerShape(10.dp)
            )
            .clip(shape = RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = appIconResource),
                contentDescription = null
            )
        }
        Text(
            text = name,
            fontSize = 32.sp,
            color = MaterialTheme.colors.onBackground
        )
        RatingBar(rating)
    }
}

@Composable
fun RatingBar(rating: Float) {

}

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
                alpha = 0.5f,
                brush = SolidColor(MaterialTheme.colors.primary),
                shape = CircleShape
            )
            .padding(vertical = 3.dp, horizontal = 6.dp),
        text = tag,
        color = MaterialTheme.colors.primary
    )
}

@Composable
fun Description(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(text = text, color = MaterialTheme.colors.onSurface)
}

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
        Box(modifier = Modifier
            .size(32.dp)
            .background(
                brush = SolidColor(Color.White),
                alpha = 0.3f,
                shape = CircleShape
            ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@Composable
fun Rating(
    modifier: Modifier = Modifier,
    rating: Float,
    reviewsCountString: String
) {
    Row(modifier = modifier) {
        Text(text = rating.toString(), fontSize = 48.sp, color = MaterialTheme.colors.onBackground)
        Column {
            RatingBar(rating)
            Text("$reviewsCountString reviews", color = MaterialTheme.colors.onSurface)
        }
    }
}

@Composable
fun ReviewItem(review: ReviewData) {
    Column {
        Row {
            Image(
                modifier = Modifier.size(48.dp),
                painter = painterResource(id = review.imageResource),
                contentDescription = null
            )
            Column {
                Text(review.name, color = MaterialTheme.colors.onBackground)
                Text(review.datePosted, color = MaterialTheme.colors.onSurface)
            }
        }
        Text(review.text, color = MaterialTheme.colors.onSurface)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PodlodkaComposeTheme {
        Box(modifier = Modifier
            .fillMaxSize()
        ) {
            GamePage()
        }
    }
}