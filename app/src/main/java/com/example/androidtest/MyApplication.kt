package com.example.androidtest

import android.app.Application
import com.example.androidtest.di.appModule
import com.unsplash.pickerandroid.photopicker.UnsplashPhotoPicker
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

        // initializing the picker library
        UnsplashPhotoPicker.init(
            this,
            "i-8cqG0g6e4w0IpBRb_wnp5ogpO-9WDhmjFwjn_QcFA",
            "ERMxXiE4umn4AUmRUyxI77CtKc_BNV8deGArxZKkutE",
            10
            /* optional page size (number of photos per page) */
        )
        /* .setLoggingEnabled(true) // if you want to see the http requests */
    }


}