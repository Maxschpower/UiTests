package com.maxsch.domain.entity

data class BookTrips(
    val success: Boolean,
    val message: String?,
    val launches: List<Launch?>?
)