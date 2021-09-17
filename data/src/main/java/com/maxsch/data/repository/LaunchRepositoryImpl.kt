package com.maxsch.data.repository

import com.apollographql.apollo.ApolloClient
import com.maxsch.domain.entity.Launch
import com.maxsch.domain.entity.Launches
import com.maxsch.domain.entity.Mission
import com.maxsch.domain.entity.Rocket
import com.maxsch.domain.repository.LaunchRepository
import io.reactivex.Completable
import io.reactivex.Single

class LaunchRepositoryImpl(
    private val apollo: ApolloClient
) : LaunchRepository {
    override fun getLaunches(): Single<Launches> =
        Single.just(
            Launches(
                "",
                false,
                listOf(
                    Launch(
                        "0",
                        "first site",
                        Mission(
                            "first mission",
                            null
                        ),
                        Rocket(
                            "name of first rocket",
                            "type of first rocket"
                        ),
                        isBooked = false
                    ),
                    Launch(
                        "1",
                        "second site",
                        Mission(
                            "second mission",
                            null
                        ),
                        Rocket(
                            "name of second rocket",
                            "type of second rocket"
                        ),
                        isBooked = false
                    )
                )
            )
        )

    override fun getLaunch(id: String): Single<Launch> =
        Single.just(
            listOf(
                Launch(
                    "0",
                    "first site",
                    Mission(
                        "first mission",
                        null
                    ),
                    Rocket(
                        "name of first rocket",
                        "type of first rocket"
                    ),
                    isBooked = false
                ),
                Launch(
                    "1",
                    "second site",
                    Mission(
                        "second mission",
                        null
                    ),
                    Rocket(
                        "name of second rocket",
                        "type of second rocket"
                    ),
                    isBooked = false
                )
            )[id.toInt()]
        )

    override fun bookTrip(launchId: String): Completable =
        Completable.complete()

    override fun cancelTrip(launchId: String): Completable =
        Completable.complete()
}