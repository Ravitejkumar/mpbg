package com.rtk.mpbg.ui.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rtk.mpbg.core.exception.Failure

abstract class BaseViewModel: ViewModel() {
    private val _failure: MutableLiveData<Failure> = MutableLiveData()
    val failure: LiveData<Failure> = _failure

    fun handleFailure(failure: Failure) {
        Log.d("Base View Model", "handleFailure: $failure")
        _failure.value = failure
    }
}