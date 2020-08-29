package com.example.androidtest.presentation.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity(){
    fun toastShort(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    fun toastLong(message:String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }


}