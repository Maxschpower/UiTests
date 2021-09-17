package com.maxsch.domain.entity

data class Launch(
    val id: String,
    val site: String? = null,
    val mission: Mission? = null,
    val rocket: Rocket? = null,
    val isBooked: Boolean = false
)