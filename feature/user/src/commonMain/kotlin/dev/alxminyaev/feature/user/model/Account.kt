package dev.alxminyaev.feature.user.model

import com.alxminyaev.tool.error.exceptions.ValidationDataException
import dev.alxminyaev.feature.user.api.models.AccountNew
import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val login: String,
    val password: String
)

fun Account.validate() {
    if (login.isBlank()) {
        throw ValidationDataException(field = "login", "Поле не должно быть пустым")
    }
    if (password.length < 6) {
        throw ValidationDataException(field = "password", "Длина пароля должна быть не меньше 6")
    }
}

fun AccountNew.toDomain(): Account {
    return Account(
        login, password
    )
}