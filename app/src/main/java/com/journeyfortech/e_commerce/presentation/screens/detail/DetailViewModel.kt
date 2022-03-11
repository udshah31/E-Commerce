package com.journeyfortech.e_commerce.presentation.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.journeyfortech.e_commerce.common.Constants.PRODUCT_ID
import com.journeyfortech.e_commerce.common.Resource
import com.journeyfortech.e_commerce.data.db.Cart
import com.journeyfortech.e_commerce.data.db.Favourite
import com.journeyfortech.e_commerce.data.model.product.ProductResponseItem
import com.journeyfortech.e_commerce.data.model.singleProduct.SingleProductResponse
import com.journeyfortech.e_commerce.data.repository.ECommerceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: ECommerceRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val productId = savedStateHandle.get<String>(PRODUCT_ID)

    private val _singleProduct =
        MutableStateFlow<Resource<SingleProductResponse>>(Resource.Loading())
    val singleProduct = _singleProduct.asStateFlow()

    private val _products =
        MutableStateFlow<Resource<List<ProductResponseItem>>>(Resource.Loading())
    val products = _products.asStateFlow()

    private fun getSingleProduct() = viewModelScope.launch {
        repository.getSingleProduct(productId!!.toInt())
            .onStart {
                _singleProduct.value = Resource.Loading()
            }.catch { e ->
                _singleProduct.value = Resource.Error(e.toString())
            }.collect { response ->
                _singleProduct.value = Resource.Success(response)
            }
    }

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
    var isCart: Boolean? by mutableStateOf(null)
    var isCartLoading: Boolean by mutableStateOf(false)

    init {
        isFav(productId!!.toLong())
        isCart(productId.toLong())
        getSingleProduct()
        getProducts()
    }

    @InternalCoroutinesApi
    private fun isFav(id: Long) = viewModelScope.launch {
        isFavoriteLoading = true
        repository.isFav(id)
            .catch {
                isFavoriteLoading = false
            }.collect {
                isFavorite = it?.isFav
                isFavoriteLoading = false
            }
    }

    fun onFavouriteClicked() = viewModelScope.launch {
        isFavoriteLoading = true
        if (isFavorite == true) {
            val delete = deleteFavById(productId!!.toLong())
            isFavorite = delete.equals(1)
        } else {
            val savedId = singleProduct.value.data!!.let {
                val item = Favourite(
                    id = it.id,
                    image = it.image,
                    description = it.description,
                    price = it.price,
                    title = it.title,
                    isFav = true
                )
                insertFav(favourite = item)
            }
            isFavorite = savedId.equals(productId!!)
        }
        isFavoriteLoading = false
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
            val delete = deleteCartById(productId!!.toLong())
            isCart = delete.equals(1)
        } else {
            val savedId = singleProduct.value.data!!.let {
                val item = Cart(
                    id = it.id,
                    image = it.image,
                    description = it.description,
                    price = it.price,
                    quantity = 1,
                    title = it.title,
                    isCart = true
                )
                insertCart(cart = item)
            }
            isCart = savedId.equals(productId!!)
        }
        isCartLoading = false
    }

    //database
    private fun insertFav(favourite: Favourite) = viewModelScope.launch {
        repository.insertFav(favourite)
    }

    private fun deleteFavById(id: Long) = viewModelScope.launch {
        repository.deleteFavById(id)
    }

    //cart
    private fun insertCart(cart: Cart) = viewModelScope.launch {
        repository.insertCart(cart)
    }

    private fun deleteCartById(id: Long) = viewModelScope.launch {
        repository.deleteCartById(id)
    }


}