package dev.alxminyaev.feature.user.repository

import dev.alxminyaev.feature.user.DataLimit
import dev.alxminyaev.feature.user.model.Account
import dev.alxminyaev.feature.user.model.Profile
import dev.alxminyaev.feature.user.model.Role
import dev.alxminyaev.feature.user.model.User

interface UserRepository {

    suspend fun findByLogin(login: String): User?

    suspend fun findAllBy(dataLimit: DataLimit, roles: List<Role>? = null): List<User>

    suspend fun save(user: User): Long

    suspend fun findById(id: Long): User?


}