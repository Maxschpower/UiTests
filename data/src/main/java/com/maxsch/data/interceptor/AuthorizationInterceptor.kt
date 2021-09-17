package com.maxsch.data.interceptor

import com.maxsch.domain.usecase.GetAuthTokenUseCase
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor(
    private val getAuthTokenUseCase: GetAuthTokenUseCase
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", getAuthTokenUseCase() ?: "")
            .build()

        return chain.proceed(request)
    }
}