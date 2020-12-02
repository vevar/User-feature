package dev.alxminyaev.feature.user.model

import kotlinx.serialization.Serializable

@Serializable
data class Tutor(
    val id: Int,
    override val profile: Profile,
    override val account: Account
) : User()