package com.example.androidtest.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidtest.data.datasource.database.entities.UnsplashPhoto_Entity
import com.example.androidtest.interfaces.UnsplashRepository
import com.example.androidtest.presentation.base.BaseViewModel
import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class PhotosViewModel(
    val unsplashRepository: UnsplashRepository,
    private val dispatcher:CoroutineDispatcher = Dispatchers.IO//Main
) :BaseViewModel(dispatcher){

    private val _photoList= MutableLiveData<ArrayList<UnsplashPhoto>>()
    val photoList:LiveData<ArrayList<UnsplashPhoto>> = _photoList

    private val _photoListSaved= MutableLiveData<List<UnsplashPhoto_Entity>>()
    val photoListSaved:LiveData<List<UnsplashPhoto_Entity>> = _photoListSaved

    private val _currentEntity= MutableLiveData<UnsplashPhoto_Entity>()
    val currentEntity:LiveData<UnsplashPhoto_Entity> = _currentEntity

    fun setCurrentEntity(current:UnsplashPhoto_Entity){
        _currentEntity.value=current
    }

    fun setUnsplashPhotoList(unsplashList:ArrayList<UnsplashPhoto>){
        _photoList.postValue(unsplashList)
    }

    fun insertAll(unsplashPhoto:UnsplashPhoto_Entity) = viewModelScope.launch(dispatcher) {
       val x= unsplashRepository.insertAll(unsplashPhoto)
        Timber.e("room inserted single image unsplashPhoto inserted ${x}")
    }

    fun insertByList( unsplashPhoto: List<UnsplashPhoto_Entity>)= viewModelScope.launch(dispatcher) {
        val x=unsplashRepository.insertByList(unsplashPhoto)
        Timber.e("room insertByList unsplashPhoto inserted ${x.size}")
    }
    fun delete(unsplashPhoto: UnsplashPhoto_Entity)= viewModelScope.launch(dispatcher) {
       val x= unsplashRepository.delete(unsplashPhoto)
        Timber.e("room delete unsplashPhoto deleted ${x}")
    }

    fun getAll()= viewModelScope.launch(dispatcher) {
        val x= unsplashRepository.getAll()
        _photoListSaved.postValue(x)
        Timber.e("room getAll unsplashPhoto getAll ${x}")
    }
    fun findListByIds(userIds: IntArray)= viewModelScope.launch(dispatcher) {
        val x=unsplashRepository.findListByIds(userIds)
        Timber.e("room findListByIds unsplashPhoto getListByIds ${x}")
    }
    fun findById(id: Int)= viewModelScope.launch(dispatcher) {
        val x = unsplashRepository.findById(id)
        Timber.e("room findById unsplashPhoto getByIds ${x}")
    }
}