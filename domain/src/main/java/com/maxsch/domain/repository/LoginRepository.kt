package com.maxsch.domain.repository

import io.reactivex.Single

interface LoginRepository {

    fun login(email: String): Single<String>
}