package com.example.androidtest.data.datasource.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Retrofit {
    val BASE_URL="https://dl.dropboxusercontent.com/s/5u21281sca8gj94/getFile.json?dl=0"

    var okHttpClient: OkHttpClient? = null
    val logging:HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().apply {
            level= HttpLoggingInterceptor.Level.BODY
        }
    }
    private fun createInstance(baseUrl:String):Retrofit{
        /*val logging = HttpLoggingInterceptor()
        logging.apply {
            level= HttpLoggingInterceptor.Level.BODY
        }*/
        if(okHttpClient==null){
            okHttpClient=OkHttpClient.Builder()
                .addInterceptor(logging)
                //.addNetworkInterceptor()
                .connectTimeout(3,TimeUnit.MINUTES)
                .readTimeout(3,TimeUnit.MINUTES)
                .writeTimeout(3,TimeUnit.MINUTES)
                .build()
        }

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient!!)
            .build()
    }
    
}