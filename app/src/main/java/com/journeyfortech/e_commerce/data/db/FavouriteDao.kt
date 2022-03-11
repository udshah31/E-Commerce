package com.journeyfortech.e_commerce.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFav(favourite: Favourite)

    @Query("SELECT * FROM favourite ORDER BY id ASC")
    fun getAllFav(): Flow<List<Favourite>>

    @Query("DELETE FROM favourite WHERE id = :id")
    suspend fun deleteFavById(id: Long)

    @Delete
    suspend fun deleteFav(favourite: Favourite)

    @Query("SELECT * FROM favourite WHERE id =:id")
    fun getFav(id: Long): Flow<Favourite?>

    @Query("SELECT * FROM favourite WHERE id = :id")
    fun loadSingleFav(id: Long): Flow<Favourite?>
}