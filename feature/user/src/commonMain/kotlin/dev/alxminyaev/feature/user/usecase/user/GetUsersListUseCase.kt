package dev.alxminyaev.feature.user.usecase.user

import dev.alxminyaev.feature.user.DataLimit
import dev.alxminyaev.feature.user.model.Role
import dev.alxminyaev.feature.user.model.User
import dev.alxminyaev.feature.user.repository.UserRepository

class GetUsersListUseCase(
    private val userRepository: UserRepository
) {

    suspend fun invoke(dataLimit: DataLimit, roles: List<Role>? = null): List<User> {
        return userRepository.findAllBy(dataLimit, roles)
    }
}