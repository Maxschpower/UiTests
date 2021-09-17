package com.maxsch.data.repository

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.rx2.rxMutate
import com.apollographql.apollo.rx2.rxQuery
import com.maxsch.BookTripMutation
import com.maxsch.CancelTripMutation
import com.maxsch.LaunchDetailsQuery
import com.maxsch.LaunchListQuery
import com.maxsch.data.mappers.toDomain
import com.maxsch.domain.entity.Launch
import com.maxsch.domain.entity.Launches
import com.maxsch.domain.repository.LaunchRepository
import io.reactivex.Completable
import io.reactivex.Single

class LaunchRepositoryImpl(
    private val apollo: ApolloClient
) : LaunchRepository {
    override fun getLaunches(): Single<Launches> =
        apollo.rxQuery(LaunchListQuery())
            .firstOrError()
            .map {
                it.data?.launches?.toDomain()
            }

    override fun getLaunch(id: String): Single<Launch> =
        apollo.rxQuery(LaunchDetailsQuery(id))
            .firstOrError()
            .map {
                it.data?.launch?.toDomain()
            }

    override fun bookTrip(launchId: String): Completable =
        apollo.rxMutate(BookTripMutation(launchId))
            .ignoreElement()

    override fun cancelTrip(launchId: String): Completable =
        apollo.rxMutate(CancelTripMutation(launchId))
            .ignoreElement()
}