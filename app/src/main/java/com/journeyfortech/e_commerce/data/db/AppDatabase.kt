package com.journeyfortech.e_commerce.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Favourite::class, Cart::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favDao(): FavouriteDao
    abstract fun cartDao(): CartDao
}