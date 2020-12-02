package dev.alxminyaev.feature.user.model

import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val login: String,
    val password: String
)