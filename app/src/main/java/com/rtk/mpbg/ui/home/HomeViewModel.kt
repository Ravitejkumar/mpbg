package com.rtk.mpbg.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rtk.mpbg.core.utils.UseCase
import com.rtk.mpbg.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getMobiles: GetMobiles): BaseViewModel() {
    private val _movies: MutableLiveData<List<MobileParcel>> = MutableLiveData()
    val movies: LiveData<List<MobileParcel>> = _movies

    fun loadMovies() =
        getMobiles(UseCase.None(), viewModelScope) { it.fold(::handleFailure, ::handleMovieList) }

    private fun handleMovieList(movies: List<Mobile>) {
        Log.d("Home ViewModel", "handleMovieList: $movies")
        _movies.value = movies.map { MobileParcel(it.id, it.brand, it.name,it.price,it.thumbImageURL,it.description,it.rating) }
    }
}