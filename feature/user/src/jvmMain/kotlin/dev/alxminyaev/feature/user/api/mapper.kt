package dev.alxminyaev.feature.user.api

import dev.alxminyaev.feature.user.api.models.UserResponse
import dev.alxminyaev.feature.user.model.Profile
import dev.alxminyaev.feature.user.api.models.Profile as ApiProfile
import dev.alxminyaev.feature.user.model.User

fun User.toUserResponse(): UserResponse {
    return UserResponse(
        id = id,
        roles = roles.map { it.id }.toTypedArray(),
        profile = profile.toApiProfile()
    )
}

fun Profile.toApiProfile(): ApiProfile {
    return ApiProfile(
        firstName = firstName,
        lastName = lastName,
        middleName = middleName
    )
}