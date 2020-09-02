package com.example.androidtest.interfaces

import com.example.androidtest.data.datasource.database.entities.UnsplashPhoto_Entity

interface IPhotoAdapterV2 {
    fun setData(dataSet: MutableList<UnsplashPhoto_Entity>)
    fun removeData(position: Int,item:UnsplashPhoto_Entity)
}