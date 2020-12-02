package dev.alxminyaev.feature.user.rds

import dev.alxminyaev.feature.user.model.Student

interface StudentRDS {
    suspend fun findById(id: Long): Student?

    suspend fun save(entity: Student): Long

    suspend fun save(entities: List<Student>): List<Long>

    suspend fun update(entity: Student)

    suspend fun delete(id: Long)

    suspend fun deleteAll()

    suspend fun findAll(): List<Student>

    suspend fun findAll(dataLimit: DataLimit): List<Student>

    class DataLimit(
        val size: Int,
        val offset: Long
    )
}