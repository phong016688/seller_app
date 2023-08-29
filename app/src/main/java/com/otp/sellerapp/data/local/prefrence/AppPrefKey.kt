package com.otp.sellerapp.data.local.prefrence

import com.otp.sellerapp.BuildConfig

object AppPrefKey {
    const val LOCAL_SECURITY = "LOCAL_SECURITY"
    const val TOKEN_REGISTER = "TOKEN_REGISTER"
    const val APP_SHARED_PREFERENCES_NAME = "APP_SHARED_PREFERENCES_NAME-${BuildConfig.APPLICATION_ID}"
    const val CURRENT_USER = "CURRENT_USER"
    const val ACCESS_TOKEN = "access_token"
    const val COOKIES_KEY = "cookies_key"
    const val USED_APPLICATION = "USED_APPLICATION"
    const val LOCAL_SETTINGS = "LOCAL_SETTINGS"
}
