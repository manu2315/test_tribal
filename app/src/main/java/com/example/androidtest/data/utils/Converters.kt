package com.example.androidtest.data.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.unsplash.pickerandroid.photopicker.data.UnsplashLinks
import com.unsplash.pickerandroid.photopicker.data.UnsplashUrls
import com.unsplash.pickerandroid.photopicker.data.UnsplashUser

class ConverterUnsplashUrls {
    private val gson = Gson()
    @TypeConverter
    fun stringToUnsplashUrls(data:String?): UnsplashUrls?{
        //val gson = Gson()
        if(data.isNullOrEmpty()){
            return null
        }

        val listType = object : TypeToken<UnsplashUrls>(){
        }.type
        return gson.fromJson<UnsplashUrls>(data,listType)
    }
    @TypeConverter
    fun unsplashUrlsListToString(obj: UnsplashUrls):String{
        //val gson = Gson()
        return gson.toJson(obj)
    }
}

class ConverterUnsplashLinks {
    private val gson = Gson()
    @TypeConverter
    fun stringToUnsplashLinks(data:String?): UnsplashLinks?{
        if(data.isNullOrEmpty()){
            return null
        }

        val type = object : TypeToken<UnsplashLinks>(){
        }.type
        return gson.fromJson<UnsplashLinks>(data,type)
    }
    @TypeConverter
    fun unsplashLinksToString(obj: UnsplashLinks):String{
        return gson.toJson(obj)
    }

}
class ConverterUnsplashUser {
    private val gson = Gson()
    @TypeConverter
    fun stringToUnsplashUser(data:String?): UnsplashUser?{
        if(data.isNullOrEmpty()){
            return null
        }

        val type = object : TypeToken<UnsplashUser>(){
        }.type
        return gson.fromJson<UnsplashUser>(data,type)
    }
    @TypeConverter
    fun unsplashUserListToString(obj: UnsplashUser):String{
        return gson.toJson(obj)
    }
}