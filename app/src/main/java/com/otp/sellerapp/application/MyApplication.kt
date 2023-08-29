package com.otp.sellerapp.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import com.otp.sellerapp.BuildConfig

@HiltAndroidApp
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}