package com.example.androidtest.data.datasource.database.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.androidtest.data.utils.ConverterUnsplashLinks
import com.example.androidtest.data.utils.ConverterUnsplashUrls
import com.example.androidtest.data.utils.ConverterUnsplashUser
import com.unsplash.pickerandroid.photopicker.data.UnsplashLinks
import com.unsplash.pickerandroid.photopicker.data.UnsplashUrls
import com.unsplash.pickerandroid.photopicker.data.UnsplashUser
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "unsplash_photo")
@Parcelize
class UnsplashPhoto_Entity (
    @PrimaryKey val id: String,
    @ColumnInfo(name = "created_at") val created_at: String,
    @ColumnInfo(name = "width")val width: Int,
    @ColumnInfo(name = "height")val height: Int,
    @ColumnInfo(name = "color")val color: String? = "#000000",
    @ColumnInfo(name = "likes")val likes: Int,
    @ColumnInfo(name = "description")val description: String?,
    @ColumnInfo(name = "urls")val urls: String,

    @ColumnInfo(name = "links")val links: String,
    @ColumnInfo(name = "user")val user: String
) : Parcelable

/*
*
* */