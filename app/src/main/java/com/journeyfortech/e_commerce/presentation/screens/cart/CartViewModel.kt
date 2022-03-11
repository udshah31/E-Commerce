package com.journeyfortech.e_commerce.presentation.screens.cart


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.journeyfortech.e_commerce.common.Resource
import com.journeyfortech.e_commerce.data.db.Cart
import com.journeyfortech.e_commerce.data.repository.ECommerceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(
    private val repository: ECommerceRepository
) : ViewModel() {


    private val _state = MutableStateFlow<Resource<List<Cart>>>(Resource.Loading())
    val state = _state.asStateFlow()

    var subTotal: String? by mutableStateOf("0.0")


    var total: Double = 0.0
    var quantity = 1
    var delivery = 50

    private fun cartItems() = viewModelScope.launch {
        repository.getAllCart()
            .onStart {
                _state.value = Resource.Loading()
            }.catch { e ->
                _state.value = Resource.Error(e.toString())
            }.collect { response ->
                _state.value = Resource.Success(response)
            }
    }

    init {
        cartItems()
        total()
    }

    //cart

    fun quantityAdded() = viewModelScope.launch {
        repository.getAllCart()
            .onStart {
                _state.value = Resource.Loading()
            }.catch { e ->
                _state.value = Resource.Error(e.toString())
            }.collect { response ->
                _state.value = Resource.Success(response)
                quantity++
                _state.value.data!!.forEach { cart ->
                    subTotal = quantity.times(cart.price!!).toString()
                }
            }
    }

    fun quantityRemoved() = viewModelScope.launch {
        if (quantity == 1) {
            repository.getAllCart()
                .onStart {
                    _state.value = Resource.Loading()
                }.catch { e ->
                    _state.value = Resource.Error(e.toString())
                }.collect { response ->
                    _state.value = Resource.Success(response)
                    _state.value.data!!.forEach { cart ->
                        subTotal = quantity.times(cart.price!!).toString()
                    }
                }
        } else {
            quantity -= 1
            repository.getAllCart()
                .onStart {
                    _state.value = Resource.Loading()
                }.catch { e ->
                    _state.value = Resource.Error(e.toString())
                }.collect { response ->
                    _state.value = Resource.Success(response)
                    _state.value.data!!.forEach { cart ->
                        subTotal = quantity.times(cart.price!!).toString()
                    }
                }
        }

    }


    private fun total() = viewModelScope.launch {
        repository.getAllCart()
            .onStart { _state.value = Resource.Loading() }
            .catch { e -> _state.value = Resource.Error(e.toString()) }
            .collect { response ->
                _state.value = Resource.Success(response)
                total =
                    _state.value.data!!.map { it.price!!.times(it.quantity!!) }.plus(delivery)
                        .sumOf { it.toDouble() }
            }
    }


    fun insertCart(cart: Cart) = viewModelScope.launch {
        repository.insertCart(cart)
    }


    fun getAllCart() = viewModelScope.launch {
        repository.getAllCart()
    }


    fun deleteCartById(id: Long) = viewModelScope.launch {
        repository.deleteCartById(id)
    }

    fun deleteCart(cart: Cart) = viewModelScope.launch {
        repository.deleteCart(cart)
    }
}