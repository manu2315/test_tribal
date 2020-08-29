package com.example.androidtest.data.datasource.network

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object Retrofit {
    val FILE_URL="https://dl.dropboxusercontent.com/s/5u21281sca8gj94/"//?dl=0"    //"https://dl.dropboxusercontent.com/s/5u21281sca8gj94/getFile.json?dl=0"

    var okHttpClient: OkHttpClient? = null
    val logging:HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().apply {
            level= HttpLoggingInterceptor.Level.BODY
        }
    }
    private fun createInstance(networkConnectionInterceptor: NetworkConnectionInterceptor, baseUrl:String):Retrofit{
        if(okHttpClient==null){
            okHttpClient=OkHttpClient.Builder()
                .addInterceptor(logging)
                .addNetworkInterceptor(networkConnectionInterceptor)
                .connectTimeout(3,TimeUnit.MINUTES)
                .readTimeout(3,TimeUnit.MINUTES)
                .writeTimeout(3,TimeUnit.MINUTES)
                .build()
        }

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build())) //.addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient!!)
            .build()
    }

    fun instanceGetFile(networkConnectionInterceptor: NetworkConnectionInterceptor):FileService{
        return createInstance(networkConnectionInterceptor, FILE_URL).create(FileService::class.java)
    }
    
}