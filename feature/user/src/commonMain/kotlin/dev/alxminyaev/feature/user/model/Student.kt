package dev.alxminyaev.feature.user.model

import kotlinx.serialization.Serializable

@Serializable
data class Student(
    val id: Long,
    override val account: Account,
    override val profile: Profile
) : User()