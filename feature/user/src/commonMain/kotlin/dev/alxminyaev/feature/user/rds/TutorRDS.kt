package dev.alxminyaev.feature.user.rds

import dev.alxminyaev.feature.user.model.Tutor

interface TutorRDS {
    suspend fun findById(id: Int): Tutor?

    suspend fun save(entity: Tutor): Int

    suspend fun save(entities: List<Tutor>): List<Int>

    suspend fun update(entity: Tutor)

    suspend fun delete(id: Int)

    suspend fun deleteAll()

    suspend fun findAll(): List<Tutor>

    suspend fun findAll(dataLimit: DataLimit): List<Tutor>

    class DataLimit(
        val size: Int,
        val offset: Long
    )
}