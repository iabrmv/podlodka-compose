package com.iabrmv.podlodkacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.iabrmv.podlodkacompose.ui.components.GameScreen
import com.iabrmv.podlodkacompose.ui.theme.PodlodkaComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: GameViewModel by viewModels()
        setContent {
            PodlodkaComposeTheme {
                with(viewModel) {
                    GameScreen(
                        appName = appName,
                        backgroundImageResource = backgroundImageResource,
                        appIconResource = appIconResource,
                        rating = rating,
                        tags = tags,
                        description = description,
                        screenshotResources = screenshotResources,
                        reviews = reviews,
                        reviewsCountString = reviewsCountString
                    )
                }
            }
        }
    }
}
