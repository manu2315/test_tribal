package com.example.androidtest.presentation.utils

import androidx.room.TypeConverter
import com.example.androidtest.data.datasource.database.entities.UnsplashPhoto_Entity
import com.example.androidtest.data.utils.ConverterUnsplashUrls
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.unsplash.pickerandroid.photopicker.data.UnsplashLinks
import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto
import com.unsplash.pickerandroid.photopicker.data.UnsplashUrls
import com.unsplash.pickerandroid.photopicker.data.UnsplashUser

fun ArrayList<UnsplashPhoto>.convertToKotlinDataClass():ArrayList<com.example.androidtest.data.models.UnsplashPhoto> {
    return this.mapTo(arrayListOf()){
        com.example.androidtest.data.models.UnsplashPhoto(
            id = it.id,
            created_at = it.created_at,
            width = it.width,
            height = it.height,
            color = it.color,
            likes = it.likes,
            description = it.description,
            urls = it.urls,
            links = it.links,
            user = it.user
        )
    }
}

fun ArrayList<UnsplashPhoto>.convertToRoomEntity():List<UnsplashPhoto_Entity>{
    return this.mapTo(mutableListOf()){
        UnsplashPhoto_Entity(
            id = it.id,
            created_at = it.created_at,
            width = it.width,
            height = it.height,
            color = it.color,
            likes = it.likes,
            description = it.description,
            urls = unsplashUrlsListToString(it.urls),
            links = unsplashLinksToString(it.links),
            user = unsplashUserListToString(it.user)
        )
    }
}

private fun stringToUnsplashUrls(data:String?): UnsplashUrls?{
    val gson = Gson()
    if(data.isNullOrEmpty()){
        return null
    }

    val listType = object : TypeToken<UnsplashUrls>(){
    }.type
    return gson.fromJson<UnsplashUrls>(data,listType)
}


private fun unsplashUrlsListToString(obj: UnsplashUrls):String{
    val gson = Gson()
    return gson.toJson(obj)
}



fun stringToUnsplashLinks(data:String?): UnsplashLinks?{
    val gson = Gson()
    if(data.isNullOrEmpty()){
        return null
    }

    val listType = object : TypeToken<List<UnsplashLinks>>(){
    }.type
    return gson.fromJson<UnsplashLinks>(data,listType)
}


fun unsplashLinksToString(obj: UnsplashLinks):String{
    val gson = Gson()
    return gson.toJson(obj)
}


fun stringToUnsplashUser(data:String?): UnsplashUser?{
    val gson = Gson()
    if(data.isNullOrEmpty()){
        return null
    }

    val type = object : TypeToken<UnsplashUser>(){
    }.type
    return gson.fromJson<UnsplashUser>(data,type)
}


fun unsplashUserListToString(obj: UnsplashUser):String{
    val gson = Gson()
    return gson.toJson(obj)
}