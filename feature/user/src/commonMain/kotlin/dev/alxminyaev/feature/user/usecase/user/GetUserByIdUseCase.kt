package dev.alxminyaev.feature.user.usecase.user

import com.alxminyaev.tool.error.exceptions.NotFoundException
import dev.alxminyaev.feature.user.model.User
import dev.alxminyaev.feature.user.repository.UserRepository

class GetUserByIdUseCase(
    private val userRepository: UserRepository
) {

    suspend fun invoke(id: Long): User {
        return userRepository.findById(id) ?: throw NotFoundException("Пользователь с id=${id} не найден")
    }
}