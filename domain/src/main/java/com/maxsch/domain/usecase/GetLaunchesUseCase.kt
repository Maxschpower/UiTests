package com.maxsch.domain.usecase

import com.maxsch.domain.repository.LaunchRepository

class GetLaunchesUseCase(
    private val repository: LaunchRepository
) {
    operator fun invoke() = repository.getLaunches()
}