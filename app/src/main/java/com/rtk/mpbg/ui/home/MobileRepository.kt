package com.rtk.mpbg.ui.home

import com.rtk.mpbg.core.exception.Failure
import com.rtk.mpbg.core.utils.Either
import com.rtk.mpbg.core.utils.NetworkHandler
import retrofit2.Call
import javax.inject.Inject

interface MobileRepository {
    fun mobiles(): Either<Failure, List<Mobile>>
//    fun movieDetails(movieId: Int): Either<Failure, MovieDetails>

    class Network
    @Inject constructor(
        private val networkHandler: NetworkHandler,
        private val service: MobileService
    ) : MobileRepository {

        override fun mobiles(): Either<Failure, List<Mobile>> {
            return when (networkHandler.isNetworkAvailable()) {
                true -> request(
                    service.mobiles(),
                    { it.map { mobileEntity -> mobileEntity.toMobile() } },
                    emptyList()
                )
                false -> Either.Left(Failure.NetworkConnection)
            }
        }

//        override fun movieDetails(movieId: Int): Either<Failure, MovieDetails> {
//            return when (networkHandler.isNetworkAvailable()) {
//                true -> request(
//                    service.movieDetails(movieId),
//                    { it.toMovieDetails() },
//                    MovieDetailsEntity.empty
//                )
//                false -> Left(NetworkConnection)
//            }
//        }

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