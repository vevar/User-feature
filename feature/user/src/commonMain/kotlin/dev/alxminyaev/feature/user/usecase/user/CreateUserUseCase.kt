package dev.alxminyaev.feature.user.usecase.user

import com.alxminyaev.tool.error.exceptions.ExistException
import dev.alxminyaev.feature.user.model.*
import dev.alxminyaev.feature.user.repository.UserRepository

class CreateUserUseCase(
    private val userRepository: UserRepository
) {

    suspend fun invoke(profile: Profile, account: Account, roles: List<Role>): Long {
        profile.validate()
        account.validate()

        val existUser = userRepository.findByLogin(account.login)

        if (existUser != null) {
            throw ExistException("Пользователь с таким логином уже существует")
        }

        val user = User(
            id = 0,
            account = account,
            profile = profile,
            roles = roles
        )

        return userRepository.save(user)
    }
}