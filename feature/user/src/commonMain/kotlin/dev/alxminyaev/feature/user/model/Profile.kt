package dev.alxminyaev.feature.user.model

import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    val firstName: String,
    val lastName: String,
    val middleName: String?,
)