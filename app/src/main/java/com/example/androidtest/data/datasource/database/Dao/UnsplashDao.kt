package com.example.androidtest.data.datasource.database.Dao

import androidx.room.*
import com.example.androidtest.data.datasource.database.entities.UnsplashPhoto_Entity

@Dao
interface UnsplashDao {
    @Query("SELECT * FROM unsplash_photo")
    suspend fun getAll(): List<UnsplashPhoto_Entity>

    @Query("SELECT * FROM unsplash_photo WHERE id IN (:userIds)")
    suspend fun loadAllByIds(userIds: IntArray): List<UnsplashPhoto_Entity>

    @Query("SELECT * FROM unsplash_photo WHERE id IN (:id)")
    suspend fun loadById(id: Int): UnsplashPhoto_Entity

    /*@Query("SELECT * FROM unsplash_photo WHERE name LIKE :name")
    fun findByName(name: String): UnsplashPhotoEntity*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg unsplashPhoto: UnsplashPhoto_Entity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertByList( unsplashPhoto: List<UnsplashPhoto_Entity>)

    @Delete
    fun delete(unsplashPhoto: UnsplashPhoto_Entity)
}