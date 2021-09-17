package com.maxsch.domain.usecase

import com.maxsch.domain.repository.LaunchRepository

class CancelTripUseCase(
    private val repository: LaunchRepository
) {
    operator fun invoke(launchId: String) = repository.cancelTrip(launchId)
}