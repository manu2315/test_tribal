package com.example.androidtest.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidtest.interfaces.UnsplashRepository
import com.example.androidtest.presentation.base.BaseViewModel
import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class PhotosViewModel(
    val unsplashRepository: UnsplashRepository,
    private val dispatcher:CoroutineDispatcher = Dispatchers.Main
) :BaseViewModel(dispatcher){

    private val _photoList= MutableLiveData<ArrayList<UnsplashPhoto>>()
    val photoList:LiveData<ArrayList<UnsplashPhoto>> = _photoList

    fun setUnsplashPhotoList(unsplashList:ArrayList<UnsplashPhoto>){
        _photoList.postValue(unsplashList)
    }

}