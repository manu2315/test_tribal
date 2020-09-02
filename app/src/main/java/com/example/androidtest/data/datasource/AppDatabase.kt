package com.example.androidtest.data.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.androidtest.data.datasource.database.Dao.UnsplashDao
import com.example.androidtest.data.datasource.database.entities.UnsplashPhoto_Entity
import com.example.androidtest.data.utils.ConverterUnsplashLinks
import com.example.androidtest.data.utils.ConverterUnsplashUrls
import com.example.androidtest.data.utils.ConverterUnsplashUser

@Database(entities = arrayOf(UnsplashPhoto_Entity::class), version = 1)
@TypeConverters(ConverterUnsplashUrls::class, ConverterUnsplashLinks::class, ConverterUnsplashUser::class)
abstract class AppDatabase :RoomDatabase(){
    abstract fun unsplashDao():UnsplashDao

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