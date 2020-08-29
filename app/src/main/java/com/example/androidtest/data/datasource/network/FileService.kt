package com.example.androidtest.data.datasource.network

import com.example.androidtest.data.models.FileApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FileService {
    @GET(value = "getFile.json")
    suspend fun getFile(@Query(value = "dl")dl:Int):Response<FileApi>
}