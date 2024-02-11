package com.example.daggerhilt

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerhilt.MainActivity.Companion.TAG
import com.example.daggerhilt.mvvm.MyViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {



    //field injection
    @Inject
    lateinit var car: Car

    val myViewModel:MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


/*
        val engine=Engine()
        val car=Car(engine)
        car.startCar()*/


//        car.startCar()

        myViewModel.startCar()

    }


    companion object {
        const val TAG = "PRABHAT"
    }
}

class Car(
    val engine: Engine,
    val number:Int

) {
    fun startCar() {
        engine.getStartEngine()
        Log.d(TAG, "${number}     startCar: ")

    }

}
//constructor injection
class Engine
    @Inject
    constructor(val piston: Piston) {

    fun getStartEngine() {
        piston.pistonStarted()

        Log.d(TAG, "getStartEngine: ")

    }

}
//constructor injection
class Piston(val numberOfPiston: NumberOfPiston){
    fun pistonStarted(){
        numberOfPiston.pistonNumber()
        Log.d(TAG, "pistonStarted: ")
    }
}


//using interface
interface NumberOfPiston{
    fun pistonNumber()
}
class NumberOfPistonImpl:NumberOfPiston{
    override fun pistonNumber() {
        Log.d(TAG, "pistonNumber: 4")
    }

}