package com.maxsch.domain.entity

data class CancelTrip(
    val success: Boolean,
    val message: String?,
    val launches: List<Launch?>?
)