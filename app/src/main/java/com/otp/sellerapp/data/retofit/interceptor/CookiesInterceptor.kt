package com.otp.sellerapp.data.retofit.interceptor

import com.otp.sellerapp.data.local.prefrence.AppPrefKey
import com.otp.sellerapp.data.local.prefrence.AppSharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Interceptor
import okhttp3.Interceptor.*
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class CookiesInterceptor @Inject constructor(
    private val preferences: AppSharedPreferences
) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        val cookies = mutableSetOf<String>()
        preferences.get(AppPrefKey.COOKIES_KEY, String::class.java)
            ?.takeIf { it.isNotEmpty() }
            ?.let { cookiesString ->
                val type = (object : TypeToken<Set<String>>() {}).type
                cookies.addAll(Gson().fromJson<Set<String>>(cookiesString, type))
            }
        cookies.forEach { builder.addHeader(KEY_COOKIE, it) }
        val response = chain.proceed(builder.build())
        response.headers(KEY_SET_COOKIE)
            .takeIf { it.isNotEmpty() }
            ?.let { preferences.put(AppPrefKey.COOKIES_KEY, Gson().toJson(it.toSet())) }
        return response
    }

    companion object {
        const val KEY_COOKIE = "Cookie"
        const val KEY_SET_COOKIE = "set-cookie"
    }
}