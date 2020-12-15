package dev.alxminyaev.feature.user.rds

import dev.alxminyaev.feature.user.model.Tutor

interface TutorRDS {
    suspend fun findById(id: Long): Tutor?

    suspend fun save(entity: Tutor): Long

    suspend fun save(entities: List<Tutor>): List<Long>

    suspend fun update(entity: Tutor)

    suspend fun delete(id: Long)

    suspend fun deleteAll()

    suspend fun findAll(): List<Tutor>

    suspend fun findAll(dataLimit: DataLimit): List<Tutor>

    class DataLimit(
        val size: Int,
        val offset: Long
    )
}