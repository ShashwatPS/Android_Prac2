package com.example.androidprac.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {
    private val mutableCountLiveData = MutableLiveData<Int>()

    fun getMutableLiveData():LiveData<Int> {
        return mutableCountLiveData
    }

    init {
        mutableCountLiveData.value = 0;
    }

}