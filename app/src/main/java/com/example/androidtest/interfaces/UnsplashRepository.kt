package com.example.androidtest.interfaces

import com.example.androidtest.data.datasource.database.entities.UnsplashPhoto_Entity
import com.example.androidtest.data.models.FileApi
import com.example.androidtest.data.utils.Resource

interface UnsplashRepository {
    fun insertAll(vararg unsplashPhoto: UnsplashPhoto_Entity)
    fun insertByList( unsplashPhoto: List<UnsplashPhoto_Entity>)
    fun delete(unsplashPhoto: UnsplashPhoto_Entity)

    suspend fun getAll(): List<UnsplashPhoto_Entity>
    suspend fun loadAllByIds(userIds: IntArray): List<UnsplashPhoto_Entity>
    suspend fun loadById(id: Int): UnsplashPhoto_Entity
}