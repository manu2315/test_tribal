package com.example.androidtest.data.datasource.database.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidtest.data.datasource.database.entities.CollaboratorEntity

@Dao
interface CollaboratorDao {
    @Query("SELECT * FROM collaborator")
    fun getAll(): List<CollaboratorEntity>

    @Query("SELECT * FROM collaborator WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<CollaboratorEntity>

    @Query("SELECT * FROM collaborator WHERE name LIKE :name")
    fun findByName(name: String): CollaboratorEntity

    @Insert
    fun insertAll(vararg collaborator: CollaboratorEntity)

    @Delete
    fun delete(collaborator: CollaboratorEntity)
}