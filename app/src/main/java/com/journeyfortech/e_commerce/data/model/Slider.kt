package com.journeyfortech.e_commerce.data.model

import com.journeyfortech.e_commerce.R

data class Slider(
    val image: Int,
    val title: String,
    val discount: String
)

val slider = listOf(
    Slider(
        R.drawable.shoe_pager_pic,
        "Nike Joyride, Nike IN",
        "-70% Off"
    ),
    Slider(
        R.drawable.shoe_pager_pic,
        "Nike Joyride, Nike IN",
        "-70% Off"
    ),
    Slider(
        R.drawable.shoe_pager_pic,
        "Adidas",
        "-70% Off"
    ),

    Slider(
        R.drawable.shoe_pager_pic,
        "Converse",
        "-70% Off"
    )
)

