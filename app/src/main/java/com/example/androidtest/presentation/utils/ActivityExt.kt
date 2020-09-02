package com.example.androidtest.presentation.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.androidtest.R
import com.example.androidtest.presentation.home.HomeFragment
import com.example.androidtest.presentation.main.MainActivity
import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto

fun FragmentActivity.getUnsplashPhotoList(): ArrayList<UnsplashPhoto>?{
    return if(this is MainActivity){
        this.mPhotos
    }else{
        return null
    }
}

fun FragmentActivity.getHomeF():Fragment{
    //val f:Fragment=this.supportFragmentManager.primaryNavigationFragment!!
    val f:Fragment= this.supportFragmentManager.findFragmentById(R.id.nav_host_fragment)!!
    return f
}