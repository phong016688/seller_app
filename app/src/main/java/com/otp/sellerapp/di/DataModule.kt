package com.otp.sellerapp.di

import com.otp.sellerapp.data.retofit.api.PersonApi
import com.otp.sellerapp.data.retofit.creator.RetrofitCreator
import com.otp.sellerapp.data.retofit.interceptor.CookiesInterceptor
import com.otp.sellerapp.data.retofit.interceptor.TokenInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun retrofitBixonex(
        tokenInterceptor: TokenInterceptor,
        cookiesInterceptor: CookiesInterceptor
    ): RetrofitCreator {
        return RetrofitCreator(
            "BuildConfig.BASE_URL",
            tokenInterceptor,
            cookiesInterceptor
        )
    }

    @Provides
    @Singleton
    fun providesBixonexAPI(@Named("Bixonex") creator: RetrofitCreator): PersonApi {
        return creator.createService(PersonApi::class.java)
    }
}