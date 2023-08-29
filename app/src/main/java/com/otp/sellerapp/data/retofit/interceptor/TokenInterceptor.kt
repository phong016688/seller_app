package com.otp.sellerapp.data.retofit.interceptor

import com.otp.sellerapp.data.dto.users.User
import com.otp.sellerapp.data.local.prefrence.AppPrefKey
import com.otp.sellerapp.data.local.prefrence.AppSharedPreferences
import com.otp.sellerapp.data.retofit.api.ApiHeader
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import java.net.HttpURLConnection
import javax.inject.Inject
import javax.inject.Singleton

private const val contentType = "Content-Type"
private const val contentTypeValue = "application/x-www-form-urlencoded"
private const val authorization = "Authorization"
private const val csrfToken = "X-CSRF-Token"

@Singleton
class TokenInterceptor @Inject constructor(
    private val preferences: AppSharedPreferences,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = initializeRequestWithHeaders(chain.request())
        val response = chain.proceed(request)
        if (response.code == HttpURLConnection.HTTP_UNAUTHORIZED) {
            preferences.clearKey(AppPrefKey.CURRENT_USER)
            preferences.clearKey(AppPrefKey.LOCAL_SETTINGS)
            preferences.clearKey(AppPrefKey.COOKIES_KEY)
        }
        val responseBody = response.body
        val responseBodyString = response.body.string()
        return createNewResponse(response, responseBody, responseBodyString)
    }

    private fun initializeRequestWithHeaders(request: Request): Request {
        return request.newBuilder().apply {
            header(contentType, contentTypeValue)
            configToken(request)
            method(request.method, request.body)
        }.build()
    }

    private fun Request.Builder.configToken(request: Request) {
        if (request.headers[ApiHeader.CUSTOM_TOKEN] != ApiHeader.NO) {
            preferences.get(AppPrefKey.CURRENT_USER, User::class.java)?.let {
                //header(csrfToken, it.csrfToken)
            }
        }
        removeHeader(ApiHeader.CUSTOM_TOKEN)
    }

    private fun createNewResponse(
        response: Response,
        responseBody: ResponseBody?,
        responseBodyString: String?,
    ): Response {
        val contentType = responseBody?.contentType()
        return response.newBuilder()
            .body((responseBodyString ?: "").toResponseBody(contentType))
            .build()
    }
}