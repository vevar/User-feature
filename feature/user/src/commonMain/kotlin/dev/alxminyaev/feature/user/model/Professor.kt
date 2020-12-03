package dev.alxminyaev.feature.user.model

import kotlinx.serialization.Serializable

@Serializable
data class Professor(
    val id: Int,
    override val account: Account?,
    override val profile: Profile,
) : User()