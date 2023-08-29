package com.otp.sellerapp.data.retofit.api

import com.otp.sellerapp.BuildConfig

object ApiHeader {
    const val NO = "no"
    const val CUSTOM_COOKIE = "${BuildConfig.APPLICATION_ID}_has_cookie"
    const val CUSTOM_TOKEN = "${BuildConfig.APPLICATION_ID}_has_token"
    const val no_cookie = "$CUSTOM_COOKIE: $NO"
    const val no_token = "$CUSTOM_TOKEN: $NO"
}