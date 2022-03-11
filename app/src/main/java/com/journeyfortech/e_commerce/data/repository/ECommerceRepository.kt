package com.journeyfortech.e_commerce.data.repository

import com.journeyfortech.e_commerce.data.api.ApiService
import com.journeyfortech.e_commerce.data.db.AppDatabase
import com.journeyfortech.e_commerce.data.db.Cart
import com.journeyfortech.e_commerce.data.db.Favourite
import com.journeyfortech.e_commerce.data.model.product.ProductResponseItem
import com.journeyfortech.e_commerce.data.model.singleProduct.SingleProductResponse
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.*


class ECommerceRepository @Inject constructor(
    private val appDatabase: AppDatabase,
    private val apiService: ApiService
) {

    suspend fun getProducts(): Flow<List<ProductResponseItem>> = flow {
        emit(apiService.getProducts())
    }.flowOn(Dispatchers.IO).conflate()


    suspend fun getSingleProduct(productId: Int): Flow<SingleProductResponse> = flow {
        emit(apiService.getSingleProduct(productId))
    }.flowOn(Dispatchers.IO).conflate()


    //cart

    suspend fun insertCart(cart: Cart) = appDatabase.cartDao().insertCart(cart)

    fun getAllCart(): Flow<List<Cart>> =
        appDatabase.cartDao().getAllCart().flowOn(Dispatchers.IO).conflate()

    suspend fun updateCart(cart: Cart) = appDatabase.cartDao().updateCart(cart)

    suspend fun deleteCartById(id: Long) = appDatabase.cartDao().deleteCartById(id)

    suspend fun deleteCart(cart: Cart) = appDatabase.cartDao().deleteCart(cart)

    fun isCart(id: Long): Flow<Cart?> = appDatabase.cartDao().getCart(id)

    //database
    suspend fun insertFav(favourite: Favourite) = appDatabase.favDao().insertFav(favourite)

    fun getAllFav(): Flow<List<Favourite>> =
        appDatabase.favDao().getAllFav().flowOn(Dispatchers.IO).conflate()

    suspend fun deleteFavById(id: Long) = appDatabase.favDao().deleteFavById(id)

    suspend fun deleteFav(favourite: Favourite) = appDatabase.favDao().deleteFav(favourite)

    fun isFav(id: Long): Flow<Favourite?> = appDatabase.favDao().getFav(id)

    fun loadSingleFav(id: Long): Flow<Favourite?> = appDatabase.favDao().loadSingleFav(id)

}