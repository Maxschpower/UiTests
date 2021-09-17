package com.maxsch.domain.repository

import com.maxsch.domain.entity.Launch
import com.maxsch.domain.entity.Launches
import io.reactivex.Completable
import io.reactivex.Single

interface LaunchRepository {

    fun getLaunches(): Single<Launches>

    fun getLaunch(id: String): Single<Launch>

    fun bookTrip(launchId:String): Completable

    fun cancelTrip(launchId:String): Completable
}