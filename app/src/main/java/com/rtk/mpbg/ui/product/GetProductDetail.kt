package com.rtk.mpbg.ui.product

import com.rtk.mpbg.core.utils.UseCase
import com.rtk.mpbg.ui.home.Mobile
import com.rtk.mpbg.ui.home.MobileRepository
import javax.inject.Inject

class GetProductDetail
@Inject constructor(private val productRepository: ProductRepository): UseCase<List<ProductDetails>, GetProductDetail.Params>() {

    override suspend fun run(params: Params) = productRepository.productDetails(params.id)

    data class Params(val id: Int)
}