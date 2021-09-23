package com.rtk.mpbg.ui.home

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MobileService
@Inject constructor(retrofit: Retrofit) : MobilesApi {
    private val mobilesApi by lazy { retrofit.create(MobilesApi::class.java) }

    override fun mobiles() = mobilesApi.mobiles()
//    override fun movieDetails(movieId: Int) = moviesApi.movieDetails(movieId)
}
