package dev.alxminyaev.feature.user.rds

import dev.alxminyaev.feature.user.model.Professor

interface ProfessorRDS {
    suspend fun findById(id: Int): Professor?

    suspend fun save(entity: Professor): Int

    suspend fun save(entities: List<Professor>): List<Int>

    suspend fun update(entity: Professor)

    suspend fun delete(id: Int)

    suspend fun deleteAll()

    suspend fun findAll(): List<Professor>

    suspend fun findAll(dataLimit: DataLimit): List<Professor>

    class DataLimit(
        val size: Int,
        val offset: Long
    )
}