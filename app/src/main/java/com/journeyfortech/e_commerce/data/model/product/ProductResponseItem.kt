package com.journeyfortech.e_commerce.data.model.product

data class ProductResponseItem(
    val category: String,
    val description: String,
    val id: Long,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)