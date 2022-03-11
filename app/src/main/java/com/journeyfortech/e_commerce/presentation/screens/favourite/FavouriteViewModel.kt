package com.journeyfortech.e_commerce.presentation.screens.favourite

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.journeyfortech.e_commerce.common.Resource
import com.journeyfortech.e_commerce.data.db.Cart
import com.journeyfortech.e_commerce.data.db.Favourite
import com.journeyfortech.e_commerce.data.repository.ECommerceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    private val repository: ECommerceRepository
) : ViewModel() {


    private val _fav = MutableStateFlow<Resource<List<Favourite>>>(Resource.Loading())
    val fav = _fav.asStateFlow()

    private val _cart = MutableStateFlow<Resource<List<Cart>>>(Resource.Loading())
    val cart = _cart.asStateFlow()


    var isCart: Boolean? by mutableStateOf(null)
    var isCartLoading: Boolean by mutableStateOf(false)

    private fun getAllFavourite() = viewModelScope.launch {
        viewModelScope.launch {
            repository.getAllFav()
                .onStart {
                    _fav.value = Resource.Loading()
                }.catch { e ->
                    _fav.value = Resource.Error(e.toString())
                }.collect { response ->
                    _fav.value = Resource.Success(response)
                }
        }
    }


    init {
        getAllFavourite()
    }

    private fun isCart(id: Long) = viewModelScope.launch {
        isCartLoading = true
        repository.isCart(id)
            .catch {
                isCartLoading = false
            }.collect {
                isCart = it?.isCart
                isCartLoading = false
            }
    }


    fun onCartClicked() = viewModelScope.launch {
        isCartLoading = true
        if (isCart == true) {
            _fav.value.data!!.map { fav ->
                _cart.value.data!!.map { cart ->
                    if (fav.id == cart.id) {
                        val delete = deleteCartById(fav.id!!)
                        isCart = delete.equals(1)
                    }
                }
            }

        } else {
            val savedId = fav.value.data!!.let {
                it.forEach { fav ->
                    val item = Cart(
                        id = fav.id,
                        image = fav.image,
                        description = fav.description,
                        price = fav.price,
                        title = fav.title,
                        isCart = true
                    )
                    insertCart(cart = item)
                }
            }
            _fav.value.data!!.map { isCart = savedId.equals(it.id) }

        }
        isCartLoading = false
    }


    //database

    fun loadSingleFav(id: Long) = viewModelScope.launch {
        repository.loadSingleFav(id)
    }

    fun deleteFavById(id: Long) = viewModelScope.launch {
        repository.deleteFavById(id)
    }

    fun deleteFav(favourite: Favourite) = viewModelScope.launch {
        repository.deleteFav(favourite)
    }


    //cart
    private fun insertCart(cart: Cart) = viewModelScope.launch {
        repository.insertCart(cart)
    }

    private fun deleteCartById(id: Long) = viewModelScope.launch {
        repository.deleteCartById(id)
    }
}