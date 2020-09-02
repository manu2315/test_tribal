package com.example.androidtest.data.datasource.database.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidtest.data.datasource.database.entities.UnsplashPhoto_Entity

@Dao
interface UnsplashDao {
    @Query("SELECT * FROM unsplash_photo")
    fun getAll(): List<UnsplashPhoto_Entity>

    @Query("SELECT * FROM unsplash_photo WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<UnsplashPhoto_Entity>

    @Query("SELECT * FROM unsplash_photo WHERE id IN (:id)")
    fun loadById(id: Int): UnsplashPhoto_Entity

    /*@Query("SELECT * FROM unsplash_photo WHERE name LIKE :name")
    fun findByName(name: String): UnsplashPhotoEntity*/

    @Insert
    fun insertAll(vararg unsplashPhoto: UnsplashPhoto_Entity)

    @Insert
    fun insertByList( unsplashPhoto: List<UnsplashPhoto_Entity>)

    @Delete
    fun delete(unsplashPhoto: UnsplashPhoto_Entity)
}