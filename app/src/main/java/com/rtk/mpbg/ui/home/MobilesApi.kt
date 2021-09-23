package com.rtk.mpbg.ui.home

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

internal interface MobilesApi {
    companion object {
        private const val PARAM_MOVIE_ID = "movieId"
        private const val MOBILES = "mobiles"
//        private const val MOVIE_DETAILS = "movie_0{$PARAM_MOVIE_ID}.json"
    }

    @GET(MOBILES)
    fun mobiles(): Call<List<MobileEntity>>
//    @GET(MOVIE_DETAILS)
//    fun movieDetails(@Path(PARAM_MOVIE_ID) movieId: Int): Call<MovieDetailsEntity>
}
