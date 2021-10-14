package com.eda.edakuntalp_odev1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class CountingViewModel : ViewModel(){
    private var counter:Int =0
    private var counterLiveData=MutableLiveData<Int>()

    open fun getInitialcount():MutableLiveData<Int>{
        counterLiveData.value=counter
        return counterLiveData
    }

    open fun getCount(){
        counter++
        counterLiveData.value=counter
    }
}