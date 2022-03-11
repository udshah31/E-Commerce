package com.journeyfortech.e_commerce.data.model

import com.journeyfortech.e_commerce.R

data class Category(
    val id: Int,
    val image: Int,
    val title: String,

    )

val category = listOf(
    Category(
        1, R.drawable.ic_shirt,
        "Shirts",
    ),
    Category(
        2, R.drawable.ic_smart_shoe,
        "Shoes",
    ),
    Category(
        3, R.drawable.ic_watch,
        "Watches",
    ),

    Category(
        4, R.drawable.ic_t_shirt,
        "T-Shirts",
    ),
    Category(
        5, R.drawable.ic_hoodie,
        "Hoodie",
    ),
    Category(
        6, R.drawable.ic_jeans,
        "Jeans",
    ),
    Category(
        7, R.drawable.ic_woman_clothes,
        "T-Shirts",
    )
)

