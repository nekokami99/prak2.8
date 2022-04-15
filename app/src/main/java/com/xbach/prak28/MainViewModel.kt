package com.xbach.prak28

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    val res = MutableLiveData<Int>()

    fun doMath(option: Int, a: Int, b: Int, c: Int){
        Calculate.setResult(option, a, b, c)
        res.value = Calculate.getResult()
    }
}
