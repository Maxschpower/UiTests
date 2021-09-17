package com.maxsch.data.mappers

import com.maxsch.LaunchListQuery
import com.maxsch.domain.entity.Launch
import com.maxsch.domain.entity.Launches
import com.maxsch.domain.entity.Mission

fun LaunchListQuery.Mission.toDomain() = Mission(name, missionPatch)

fun LaunchListQuery.Launch.toDomain() = Launch(id, site, mission?.toDomain())

fun LaunchListQuery.Launches.toDomain() = Launches(
    cursor,
    hasMore,
    launches.map { it?.toDomain() }
)