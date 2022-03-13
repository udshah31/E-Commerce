package com.journeyfortech.e_commerce.presentation.screens.cart


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

    private val _subTotal = MutableStateFlow<Double>(0.0)
    val subTotal = _subTotal.asStateFlow()

    private val _total = MutableStateFlow<Double>(0.0)
    val total = _total.asStateFlow()

    private val _quantity = MutableStateFlow<Int>(1)
    val quantity = _quantity.asStateFlow()

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
                _quantity.value++
                _state.value.data!!.forEach { cart ->
                    _subTotal.value = _quantity.value.times(cart.price!!)
                }
            }
    }

    fun quantityRemoved() = viewModelScope.launch {
        if (_quantity.value == 1) {
            repository.getAllCart()
                .onStart {
                    _state.value = Resource.Loading()
                }.catch { e ->
                    _state.value = Resource.Error(e.toString())
                }.collect { response ->
                    _state.value = Resource.Success(response)
                    _state.value.data!!.forEach { cart ->
                        _subTotal.value = _quantity.value.times(cart.price!!)

                    }
                }
        } else {
            _quantity.value -= 1
            repository.getAllCart()
                .onStart {
                    _state.value = Resource.Loading()
                }.catch { e ->
                    _state.value = Resource.Error(e.toString())
                }.collect { response ->
                    _state.value = Resource.Success(response)
                    _state.value.data!!.forEach { cart ->
                        _subTotal.value = _quantity.value.times(cart.price!!)
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
                _total.value =
                    _state.value.data!!.map { it.price!!.times(_quantity.value) }.plus(delivery)
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

    fun updateCartItem(cart: Cart) = viewModelScope.launch {
        repository.updateCart(cart)
    }


}