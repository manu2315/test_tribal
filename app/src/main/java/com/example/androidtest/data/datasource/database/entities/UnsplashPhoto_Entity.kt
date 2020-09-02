package com.example.androidtest.data.datasource.database.entities

import android.os.Parcelable
import androidx.room.*
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
    @TypeConverters(ConverterUnsplashUrls::class)
    @ColumnInfo(name = "urls")val urls: UnsplashUrls,
    @TypeConverters(ConverterUnsplashLinks::class)
    @ColumnInfo(name = "links")val links: UnsplashLinks,
    @TypeConverters(ConverterUnsplashUser::class)
    @ColumnInfo(name = "user")val user: UnsplashUser
) : Parcelable

/*
*
* */