package com.example.androidtest.data.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidtest.data.datasource.database.Dao.UnsplashDao
import com.example.androidtest.data.datasource.database.entities.UnsplashPhoto_Entity

@Database(entities = arrayOf(UnsplashPhoto_Entity::class), version = 1)
abstract class AppDatabase :RoomDatabase(){
    abstract fun collaboratorDao():UnsplashDao

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