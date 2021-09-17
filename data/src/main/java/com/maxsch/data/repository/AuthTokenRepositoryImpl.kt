package com.maxsch.data.repository

import com.maxsch.data.datasource.AuthTokenDataSource
import com.maxsch.domain.repository.AuthTokenRepository

class AuthTokenRepositoryImpl(
    private val dataSource: AuthTokenDataSource
) : AuthTokenRepository {
    override var token: String?
        get() = dataSource.token
        set(value) {
            dataSource.token = value
        }
}