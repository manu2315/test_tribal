package com.example.androidtest.data.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidtest.data.datasource.database.Dao.CollaboratorDao
import com.example.androidtest.data.datasource.database.entities.CollaboratorEntity

@Database(entities = arrayOf(CollaboratorEntity::class), version = 1)
abstract class AppDatabase :RoomDatabase(){
    abstract fun collaboratorDao():CollaboratorDao

    companion object {

        @Volatile
        private var INSTANCE_DB: AppDatabase? =null
        fun getDatabase(context: Context):AppDatabase{
            val tempInstance = INSTANCE_DB
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE_DB = instance
                return instance
            }
        }
    }
}