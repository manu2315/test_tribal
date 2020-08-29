package com.example.androidtest

import android.app.Application
import com.example.androidtest.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber
import timber.log.Timber.DebugTree


class MyApplication:Application() {


    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger(Level.ERROR)
            androidContext(this@MyApplication)
            modules(appModule)
        }
        //Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }


}