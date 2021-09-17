package com.maxsch.domain.usecase

import com.maxsch.domain.repository.AuthTokenRepository

class SetAuthTokenUseCase(
    private val repository: AuthTokenRepository
) {
    operator fun invoke(token: String) {
        repository.token = token
    }
}