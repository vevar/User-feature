package dev.alxminyaev.feature.user.model

import com.alxminyaev.tool.error.exceptions.ValidationDataException
import kotlinx.serialization.Serializable
import dev.alxminyaev.feature.user.api.models.Profile as ApiProfile


@Serializable
data class Profile(
    val firstName: String,
    val lastName: String,
    val middleName: String?,
)

fun Profile.validate() {
    if (firstName.isBlank()) {
        throw ValidationDataException(field = "firstName", message = "Поле не должно быть пустым")
    }
    if (lastName.isBlank()) {
        throw ValidationDataException(field = "lastName", message = "Поле не должно быть пустым")
    }
}

fun ApiProfile.toDomain(): Profile {
    return Profile(
        firstName = firstName, lastName = lastName, middleName = middleName
    )
}