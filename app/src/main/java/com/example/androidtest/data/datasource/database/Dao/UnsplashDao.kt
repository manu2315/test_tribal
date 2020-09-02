package com.example.androidtest.data.datasource.database.Dao

import androidx.room.*
import com.example.androidtest.data.datasource.database.entities.UnsplashPhoto_Entity

@Dao
interface UnsplashDao {
    @Query("SELECT * FROM unsplash_photo")
    suspend fun getAll(): List<UnsplashPhoto_Entity>

    @Query("SELECT * FROM unsplash_photo WHERE id IN (:userIds)")
    suspend fun findListByIds(userIds: IntArray): List<UnsplashPhoto_Entity>

    @Query("SELECT * FROM unsplash_photo WHERE id IN (:id)")
    suspend fun findById(id: Int): UnsplashPhoto_Entity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(unsplashPhoto: UnsplashPhoto_Entity):Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertByList( unsplashPhoto: List<UnsplashPhoto_Entity>):List<Long>

    @Delete
    fun delete(unsplashPhoto: UnsplashPhoto_Entity):Int

    @Update
    fun update(unsplashPhoto: UnsplashPhoto_Entity)
}