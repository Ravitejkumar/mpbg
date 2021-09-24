package com.rtk.mpbg.ui.product

import android.util.Log
import com.rtk.mpbg.core.exception.Failure
import com.rtk.mpbg.core.utils.Either
import com.rtk.mpbg.core.utils.NetworkHandler
import retrofit2.Call
import javax.inject.Inject

interface ProductRepository {
    fun productDetails(mobileId: Int): Either<Failure, List<ProductDetails>>

    class Network
    @Inject constructor(
        private val networkHandler: NetworkHandler,
        private val service: ProductService
    ) : ProductRepository {


        override fun productDetails(mobileId: Int): Either<Failure, List<ProductDetails>> {
            Log.d("product repo", "productDetails: $mobileId")
            return when (networkHandler.isNetworkAvailable()) {
                true -> request(
                    service.mobileDetails(mobileId),
                    { it.map { productEntity -> productEntity.toProductDetail() } },
                    emptyList()
                )
                false -> Either.Left(Failure.NetworkConnection)
            }
        }

        private fun <T, R> request(
            call: Call<T>,
            transform: (T) -> R,
            default: T
        ): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Either.Right(transform((response.body() ?: default)))
                    false -> Either.Left(Failure.ServerError)
                }
            } catch (exception: Throwable) {
                Either.Left(Failure.ServerError)
            }
        }
    }
}