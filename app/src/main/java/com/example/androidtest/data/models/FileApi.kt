package com.example.androidtest.data.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class FileApi(
    @Json(name="code")
    val code: Int,
    @Json(name="data")
    val data: @RawValue Data?=null,
    @Json(name="success")
    val success: Boolean
) : Parcelable