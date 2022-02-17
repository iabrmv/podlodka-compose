package com.iabrmv.podlodkacompose

import androidx.lifecycle.ViewModel
import com.iabrmv.podlodkacompose.data.ReviewData

class GameViewModel: ViewModel() {
    val appName: String = "DoTA2"
    val backgroundImageResource = R.drawable.header_image
    val appIconResource = R.drawable.icon
    val rating = 4.9f
    val tags = listOf("MOBA", "MULTIPLAYER", "STRATEGY")
    val description = "Dota 2 is a multiplayer online battle arena (MOBA) game which has two teams of five players compete to collectively destroy a large structure defended by the opposing team known as the \"Ancient\", whilst defending their own."
    val screenshotResources= listOf(R.drawable.video1, R.drawable.video2)
    val reviews = listOf(
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
    )
    val reviewsCountString = "70M"
}