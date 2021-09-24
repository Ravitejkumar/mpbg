package com.rtk.mpbg.ui.product

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductService
@Inject constructor(retrofit: Retrofit) : ProductApi {
    private val productApi by lazy { retrofit.create(ProductApi::class.java) }

    override fun mobileDetails(mobileId: Int) = productApi.mobileDetails(mobileId)
}