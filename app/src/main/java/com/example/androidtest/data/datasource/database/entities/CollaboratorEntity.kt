package com.example.androidtest.data.datasource.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androidtest.data.models.Location

@Entity(tableName = "collaborator")
class CollaboratorEntity (
    @PrimaryKey val uid: String,
    @ColumnInfo(name = "latitude") val latitude: String,
    @ColumnInfo(name = "longitude")val longitude: String,
    @ColumnInfo(name = "mail")val mail: String,
    @ColumnInfo(name = "name")val name: String
)