package dev.alxminyaev.feature.user.repository

import dev.alxminyaev.feature.user.datasource.StudentDataSource
import dev.alxminyaev.feature.user.model.Student
import dev.alxminyaev.feature.user.rds.StudentRDS


class StudentRepository(
    private val mainDataSource: StudentDataSource,
    private val cacheDataSource: StudentDataSource? = null
) : StudentRDS {

    override suspend fun findById(id: Long): Student? {
        return cacheDataSource?.findById(id) ?: mainDataSource.findById(id)
    }

    override suspend fun save(entity: Student): Long {
        return mainDataSource.save(entity).also {
            cacheDataSource?.save(entity.copy(id = it))
        }
    }

    override suspend fun save(entities: List<Student>): List<Long> {
        return mainDataSource.save(entities).also {

            cacheDataSource?.run {
                val savedList = entities.mapIndexed { index, entity ->
                    entity.copy(id = it[index])
                }
                save(savedList)
            }
        }
    }

    override suspend fun update(entity: Student) {
        return mainDataSource.update(entity).also {
            cacheDataSource?.update(entity)
        }
    }

    override suspend fun delete(id: Long) {
        return mainDataSource.delete(id).also {
            cacheDataSource?.delete(id)
        }
    }

    override suspend fun deleteAll() {
        cacheDataSource?.deleteAll()
        mainDataSource.deleteAll()
    }

    override suspend fun findAll(): List<Student> {
        return try {
            mainDataSource.findAll().also {
                cacheDataSource?.deleteAll()
                cacheDataSource?.save(it)
            }
        } catch (e: Throwable) {
            cacheDataSource?.findAll() ?: throw e
        }
    }

    override suspend fun findAll(dataLimit: StudentRDS.DataLimit): List<Student> {
        return try {
            mainDataSource.findAll(dataLimit).also {
                cacheDataSource?.deleteAll()
                cacheDataSource?.save(it)
            }
        } catch (e: Throwable) {
            cacheDataSource?.findAll(dataLimit) ?: throw e
        }
    }
}