package com.rtk.mpbg.ui.product

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rtk.mpbg.core.utils.UseCase
import com.rtk.mpbg.ui.base.BaseViewModel
import com.rtk.mpbg.ui.home.GetMobiles
import com.rtk.mpbg.ui.home.Mobile
import com.rtk.mpbg.ui.home.MobileParcel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val getProduct: GetProductDetail): BaseViewModel() {
    private val _product: MutableLiveData<List<ProductDetails>> = MutableLiveData()
    val product: LiveData<List<ProductDetails>> = _product

    fun getProdcutDetails(mobileId: Int) =
        getProduct(GetProductDetail.Params(mobileId), viewModelScope) { it.fold(::handleFailure, ::handleProductDetails) }

    private fun handleProductDetails(product: List<ProductDetails>) {
        Log.d("Home ViewModel", "handleMovieList: $product")
        _product.value = product
    }
}