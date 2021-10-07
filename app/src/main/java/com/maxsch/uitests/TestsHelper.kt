package com.maxsch.uitests

import android.content.SharedPreferences

class TestsHelper(
    private val sharedPreferences: SharedPreferences
) {
    fun clearAuthToken() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}