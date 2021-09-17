package com.maxsch.domain.usecase

import com.maxsch.domain.repository.AuthTokenRepository

class GetAuthTokenUseCase(
    private val repository: AuthTokenRepository
) {

    operator fun invoke() = repository.token
}