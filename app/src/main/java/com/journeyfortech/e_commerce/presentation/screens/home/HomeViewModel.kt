package com.journeyfortech.e_commerce.presentation.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.journeyfortech.e_commerce.common.Resource
import com.journeyfortech.e_commerce.data.db.Favourite
import com.journeyfortech.e_commerce.data.model.product.ProductResponseItem
import com.journeyfortech.e_commerce.data.repository.ECommerceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@InternalCoroutinesApi
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ECommerceRepository
) : ViewModel() {

    private val _products =
        MutableStateFlow<Resource<List<ProductResponseItem>>>(Resource.Loading())
    val products = _products.asStateFlow()


    private fun getProducts() = viewModelScope.launch {
        repository.getProducts()
            .onStart {
                _products.value = Resource.Loading()
            }.catch { e ->
                _products.value = Resource.Error(e.toString())
            }.collect { response ->
                _products.value = Resource.Success(response)

            }
    }

    var isFavorite: Boolean? by mutableStateOf(null)
    var isFavoriteLoading: Boolean by mutableStateOf(false)


    init {
        getProducts()
    }


    @InternalCoroutinesApi
    fun isFav(id: Long) = viewModelScope.launch {
        isFavoriteLoading = true
        repository.isFav(id)
            .catch {
                isFavoriteLoading = false
            }.collect {
                isFavorite = it?.isFav
                isFavoriteLoading = false
            }
    }

    fun onFavouriteClicked(item: ProductResponseItem) = viewModelScope.launch {
        isFavoriteLoading = true
        if (isFavorite == true) {
            val delete = deleteFavById(item.id)
            isFavorite = delete.equals(1)

        } else {
            val fav = Favourite(
                id = item.id,
                image = item.image,
                description = item.description,
                price = item.price,
                title = item.title,
                isFav = true
            )
            insertFav(favourite = fav)
            isFavorite = fav.equals(item.id)

        }
        isFavoriteLoading = false
    }

    //database
    private fun insertFav(favourite: Favourite) = viewModelScope.launch {
        repository.insertFav(favourite)
    }


    fun getAllFav() = viewModelScope.launch {
        repository.getAllFav()
    }


    private fun deleteFavById(id: Long) = viewModelScope.launch {
        repository.deleteFavById(id)
    }

    fun deleteFav(favourite: Favourite) = viewModelScope.launch {
        repository.deleteFav(favourite)
    }

}