package com.otp.sellerapp.di

import com.otp.sellerapp.data.repository.AuthRepository
import com.otp.sellerapp.data.repository.AuthRepositoryImpl
import com.otp.sellerapp.data.retofit.api.PersonApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.FlowPreview
import javax.inject.Singleton

@FlowPreview
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(repo: AuthRepositoryImpl): AuthRepository
}
