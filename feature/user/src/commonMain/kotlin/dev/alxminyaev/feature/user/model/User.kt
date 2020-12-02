package dev.alxminyaev.feature.user.model

import kotlinx.serialization.Serializable

abstract class User {
    abstract val account: Account
    abstract val profile: Profile

}
