package com.maxsch.domain.entity

data class Launches(
    val cursor: String,
    val hasMore: Boolean,
    val launches: List<Launch?>
)