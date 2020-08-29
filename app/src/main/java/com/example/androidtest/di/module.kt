package com.example.androidtest.di

import com.example.androidtest.data.datasource.network.FileService
import com.example.androidtest.data.datasource.network.NetworkConnectionInterceptor
import com.example.androidtest.data.datasource.network.Retrofit
import com.example.androidtest.data.respositories.FileRepositoryImpl
import com.example.androidtest.domain.CollaboratorViewModel
import com.example.androidtest.interfaces.FileRepository
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single { NetworkConnectionInterceptor(get()) }
    single<FileService> { Retrofit.instanceGetFile(get()) }
    single<FileRepository> { FileRepositoryImpl(get()) }
    viewModel { CollaboratorViewModel(get()) }

}