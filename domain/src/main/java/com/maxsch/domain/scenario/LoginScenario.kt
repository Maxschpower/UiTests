package com.maxsch.domain.scenario

import com.maxsch.domain.repository.LoginRepository
import com.maxsch.domain.usecase.SetAuthTokenUseCase
import io.reactivex.Completable

class LoginScenario(
    private val setAuthTokenUseCase: SetAuthTokenUseCase,
    private val loginRepository: LoginRepository
) {
    operator fun invoke(email: String): Completable =
        loginRepository.login(email)
            .flatMapCompletable {
                setAuthTokenUseCase(it)
                Completable.complete()
            }
}