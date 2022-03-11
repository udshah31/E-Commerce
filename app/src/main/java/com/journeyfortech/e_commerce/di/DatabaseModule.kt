package com.journeyfortech.e_commerce.di

import android.content.Context
import androidx.room.Room
import com.journeyfortech.e_commerce.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, AppDatabase::class.java,
        "fav_db.db"
    )
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideFavDao(database: AppDatabase) = database.favDao()

    @Singleton
    @Provides
    fun provideCartDao(database: AppDatabase) = database.cartDao()

}