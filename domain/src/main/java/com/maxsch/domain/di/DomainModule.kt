package com.maxsch.domain.di

import com.maxsch.domain.scenario.LoginScenario
import com.maxsch.domain.usecase.*
import org.koin.dsl.factory
import org.koin.dsl.module

val domainModule = module {
    factory<GetLaunchesUseCase>()

    factory<GetAuthTokenUseCase>()

    factory<SetAuthTokenUseCase>()

    factory<BookTripUseCase>()

    factory<CancelTripUseCase>()

    factory<LoginScenario>()
}