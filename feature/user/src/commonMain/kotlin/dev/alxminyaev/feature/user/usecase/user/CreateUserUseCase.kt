package dev.alxminyaev.feature.user.usecase.user

import com.alxminyaev.tool.error.exceptions.ExistException
import com.alxminyaev.tool.error.exceptions.ValidationDataException
import dev.alxminyaev.feature.user.model.*
import dev.alxminyaev.feature.user.repository.UserRepository

class CreateUserUseCase(
    private val userRepository: UserRepository
) {

    suspend fun invoke(profile: Profile, account: Account, roles: List<Role>): Long {
        profile.validate()
        account.validate()
        if (roles.isEmpty()) {
            throw ValidationDataException(field = "roles", message = "Хотя бы одна роль должна быть задана")
        }

        val existUser = userRepository.findByLogin(account.login)

        if (existUser != null) {
            throw ExistException("Пользователь с таким логином уже существует")
        }

        val formattedRoles = when {
            roles.contains(Role.ADMIN) -> {
                roles.toMutableSet()
            }
            roles.contains(Role.STUDENT) -> {
                roles.toMutableSet().apply {
                    add(Role.OUT_STUDY_MEMBER)
                }
            }
            roles.contains(Role.PROFESSOR) -> {
                roles.toMutableSet().apply {
                    add(Role.OUT_STUDY_ORGANIZER)
                }
            }
            else -> roles.toMutableSet()
        }
        val user = User(
            id = 0,
            account = account,
            profile = profile,
            roles = formattedRoles
        )

        return userRepository.save(user)
    }
}