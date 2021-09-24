package com.rtk.mpbg.ui.home

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

internal interface MobilesApi {
    companion object {
        private const val MOBILES = "mobiles"
    }

    @GET(MOBILES)
    fun mobiles(): Call<List<MobileEntity>>
}
