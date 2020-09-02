package com.example.androidtest.presentation.utils

import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto

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