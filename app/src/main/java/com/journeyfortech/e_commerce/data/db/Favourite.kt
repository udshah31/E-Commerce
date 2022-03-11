package com.journeyfortech.e_commerce.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite")
data class Favourite(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val title: String? = null,
    val description: String? = null,
    val price: Double? = null,
    val image: String? = null,
    val isFav: Boolean? = null
)