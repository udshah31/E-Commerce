package com.journeyfortech.e_commerce.data.model

import com.journeyfortech.e_commerce.R

data class Offer(
    val image: Int
)

val offers = listOf(
    Offer(R.drawable.offer),
    Offer(R.drawable.offers_1),
    Offer(R.drawable.offers_2),
    Offer(R.drawable.offers_3),
    Offer(R.drawable.offers_4),
)
