package com.example.daggerhilt.mvvm

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



@HiltViewModel
class MyViewModel
    @Inject
    constructor(private val myRepo: MyRepo)
    :ViewModel() {

        fun startCar(){
            Log.d("PRABHAT", "FROM VIEMODEL ")
            myRepo.car.startCar()
        }
}