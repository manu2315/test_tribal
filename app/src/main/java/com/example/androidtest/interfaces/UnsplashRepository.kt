package com.example.androidtest.interfaces

import com.example.androidtest.data.datasource.database.entities.UnsplashPhoto_Entity
import com.example.androidtest.data.models.FileApi
import com.example.androidtest.data.utils.Resource

interface UnsplashRepository {
    fun insertAll(unsplashPhoto: UnsplashPhoto_Entity):Long
    fun insertByList( unsplashPhoto: List<UnsplashPhoto_Entity>):List<Long>
    fun delete(unsplashPhoto: UnsplashPhoto_Entity):Int
    fun update(unsplashPhoto: UnsplashPhoto_Entity)
    suspend fun getAll(): List<UnsplashPhoto_Entity>
    suspend fun findListByIds(userIds: IntArray): List<UnsplashPhoto_Entity>
    suspend fun findById(id: Int): UnsplashPhoto_Entity
}