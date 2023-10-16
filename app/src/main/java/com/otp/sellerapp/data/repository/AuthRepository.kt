package com.otp.sellerapp.data.repository

import com.otp.sellerapp.data.retofit.api.PersonApi
import javax.inject.Inject
import javax.inject.Singleton

interface  AuthRepository{
    fun login()
}
@Singleton
class AuthRepositoryImpl @Inject constructor(val api: PersonApi):AuthRepository {
    override fun login() {

    }

}