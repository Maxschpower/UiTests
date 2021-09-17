package com.maxsch.data.datastorage

import android.content.SharedPreferences

private val AUTH_TOKEN_KEY = "auth_token_key"

class MockAuthTokenDataStorage(
    private val sharedPreferences: SharedPreferences
) : AuthTokenDataStorage {
    override var token: String?
        get() = sharedPreferences.getString(AUTH_TOKEN_KEY, null)
        set(value) {
            sharedPreferences.edit().putString(AUTH_TOKEN_KEY, value).apply()
        }
}