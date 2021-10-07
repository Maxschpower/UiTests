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
    private val launchesList = listOf(
        Launch(
            "0",
            "CCAFS SLC 40",
            Mission(
                "Starlink-15 (v1.0)",
                null
            ),
            Rocket(
                "Falcon 9",
                "FT"
            ),
            isBooked = false
        ),
        Launch(
            "1",
            "VAFB SLC 4E",
            Mission(
                "Sentinel-6 Michael Freilich",
                null
            ),
            Rocket(
                "Falcon 9",
                "FT"
            ),
            isBooked = false
        ),
        Launch(
            "2",
            "KSC LC 39A",
            Mission(
                "Crew-1",
                null
            ),
            Rocket(
                "Falcon 9",
                "FT"
            ),
            isBooked = false
        ),
        Launch(
            "3",
            "CCAFS SLC 40",
            Mission(
                "GPS III SV04 (Sacagawea)",
                null
            ),
            Rocket(
                "Falcon 9",
                "FT"
            ),
            isBooked = false
        ),
        Launch(
            "4",
            "CCAFS SLC 40",
            Mission(
                "Starlink-14 (v1.0)",
                null
            ),
            Rocket(
                "Falcon 9",
                "FT"
            ),
            isBooked = false
        ),
        Launch(
            "5",
            "KSC LC 39A",
            Mission(
                "Starlink-13 (v1.0)",
                null
            ),
            Rocket(
                "Falcon 9",
                "FT"
            ),
            isBooked = false
        ),
        Launch(
            "6",
            "KSC LC 39A",
            Mission(
                "Starlink-12 (v1.0)",
                null
            ),
            Rocket(
                "Falcon 9",
                "FT"
            ),
            isBooked = false
        )
    )

    override fun getLaunches(): Single<Launches> =
        Single.just(
            Launches(
                "",
                false,
                launchesList
            )
        )

    override fun getLaunch(id: String): Single<Launch> =
        Single.just(launchesList[id.toInt()])

    override fun bookTrip(launchId: String): Completable =
        Completable.complete()

    override fun cancelTrip(launchId: String): Completable =
        Completable.complete()
}