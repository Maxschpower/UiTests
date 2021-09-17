package com.maxsch.data.repository

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.rx2.rxMutate
import com.maxsch.LoginMutation
import com.maxsch.domain.repository.LoginRepository
import io.reactivex.Single

class LoginRepositoryImpl(
    private val apolloClient: ApolloClient
) : LoginRepository {

    override fun login(email: String): Single<String> =
        Single.just("email")
}