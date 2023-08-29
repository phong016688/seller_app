package com.otp.sellerapp.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.FlowPreview

@FlowPreview
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

//    @Binds
//    @Singleton
//    abstract fun bindAuthRepository(repo: AuthRepositoryImpl): AuthRepository
}
