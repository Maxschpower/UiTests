package com.maxsch.data.mappers

import com.maxsch.LaunchDetailsQuery
import com.maxsch.domain.entity.Launch
import com.maxsch.domain.entity.Mission
import com.maxsch.domain.entity.Rocket

fun LaunchDetailsQuery.Mission.toDomain() = Mission(name, missionPatch)

fun LaunchDetailsQuery.Rocket.toDomain() = Rocket(
    name, type
)

fun LaunchDetailsQuery.Launch.toDomain() = Launch(
    id,
    site,
    mission?.toDomain(),
    rocket?.toDomain(),
    isBooked
)
