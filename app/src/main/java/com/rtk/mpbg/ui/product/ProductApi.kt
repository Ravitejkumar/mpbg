package com.rtk.mpbg.ui.product

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

internal interface ProductApi {
    companion object {
        private const val PARAM_MOBILE_ID = "mobileId"
        private const val MOBILE_DETAILS = "mobiles/{mobileId}/images"
    }

    @GET(MOBILE_DETAILS)
    fun mobileDetails(@Path(PARAM_MOBILE_ID) mobileId: Int): Call<List<ProductDetailEntity>>
}