package com.example.androidtest.presentation.utils

import androidx.fragment.app.FragmentActivity
import com.example.androidtest.presentation.main.MainActivity
import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto

fun FragmentActivity.getUnsplashPhotoList(): ArrayList<UnsplashPhoto>?{
    return if(this is MainActivity){
        this.mPhotos
    }else{
        return null
    }
}