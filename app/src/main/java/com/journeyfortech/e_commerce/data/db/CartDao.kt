package com.journeyfortech.e_commerce.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCart(cart: Cart)

    @Query("SELECT * FROM cart ORDER BY id ASC")
    fun getAllCart(): Flow<List<Cart>>


    @Query("DELETE FROM cart WHERE id = :id")
    suspend fun deleteCartById(id: Long)

    @Delete
    suspend fun deleteCart(cart: Cart)

    @Update
    suspend fun updateCart(cart: Cart)


    @Query("SELECT * FROM cart WHERE id =:id")
    fun getCart(id: Long): Flow<Cart>
}