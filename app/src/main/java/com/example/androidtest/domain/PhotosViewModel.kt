package com.example.androidtest.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtest.interfaces.FileRepository
import com.example.androidtest.presentation.base.BaseViewModel
import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

class PhotosViewModel(
    val fileRepository: FileRepository,
    private val dispatcher:CoroutineDispatcher = Dispatchers.Main
) :BaseViewModel(dispatcher){

    private val _photoList= MutableLiveData<ArrayList<UnsplashPhoto>>()
    val photoList:LiveData<ArrayList<UnsplashPhoto>> = _photoList

    fun setUnsplashPhotoList(unsplashList:ArrayList<UnsplashPhoto>){
        _photoList.postValue(unsplashList)
    }

}