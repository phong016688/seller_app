package com.otp.sellerapp.data.retofit.api

import retrofit2.http.GET

interface PersonApi {
    @GET("/api")
    suspend fun getPersonInfo(): Any
}