package com.journeyfortech.e_commerce.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class Cart(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val title: String? = null,
    val description: String? = null,
    val price: Double? = null,
    val quantity: Int? = null,
    val image: String? = null,
    val isCart: Boolean? = null
)