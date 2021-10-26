package com.dan.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel2 : ViewModel(){

    private lateinit var timer: CountDownTimer

    var finished = MutableLiveData<Boolean>()
    var timerValue = MutableLiveData<Long>()

    private val secondsTime = MutableLiveData<Int>()

    fun seconds() : LiveData<Int> {
        return secondsTime
    }

    fun startTimer(){
        timer = object : CountDownTimer(timerValue.value!!.toLong(),1000){

            override fun onFinish(){
                finished.value = true
            }

            override fun onTick(p0: Long) {
                secondsTime.value = (p0/1000).toInt()
            }
        }.start()
    }

    fun stopTimer(){
        timer.cancel()
    }


}