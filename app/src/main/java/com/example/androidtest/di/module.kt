package com.example.androidtest.di

import com.example.androidtest.data.datasource.AppDatabase
import com.example.androidtest.data.datasource.network.NetworkConnectionInterceptor
import com.example.androidtest.data.datasource.network.Retrofit
import com.example.androidtest.data.respositories.UnsplashRepositoryImpl
import com.example.androidtest.domain.PhotosViewModel
import com.example.androidtest.interfaces.UnsplashRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single { AppDatabase.getDatabase(get()) }
    single<UnsplashRepository> { UnsplashRepositoryImpl(get<AppDatabase>().unsplashDao())}
    viewModel { PhotosViewModel(get()) }

}