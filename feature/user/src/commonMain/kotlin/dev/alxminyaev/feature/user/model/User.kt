package dev.alxminyaev.feature.user.model

data class User(
    val id: Long,
    val account: Account?,
    val profile: Profile,
    val roles: Set<Role>
)
