package com.otp.sellerapp.di

import android.content.Context
import com.otp.sellerapp.data.local.prefrence.AppPreferencesImpl
import com.otp.sellerapp.data.local.prefrence.AppSharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideNetworkAppPreferencesImpl(@ApplicationContext context: Context): AppSharedPreferences {
        return AppPreferencesImpl(context)
    }
}