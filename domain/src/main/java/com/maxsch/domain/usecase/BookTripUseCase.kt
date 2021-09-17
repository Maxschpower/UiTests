package com.maxsch.domain.usecase

import com.maxsch.domain.repository.LaunchRepository

class BookTripUseCase(
    private val repository: LaunchRepository
) {
    operator fun invoke(launchId: String) = repository.bookTrip(launchId)
}