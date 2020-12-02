package dev.alxminyaev.feature.user.repository

import dev.alxminyaev.feature.user.datasource.ProfessorDataSource
import dev.alxminyaev.feature.user.model.Professor
import dev.alxminyaev.feature.user.rds.ProfessorRDS


class ProfessorRepository(
    private val mainDataSource: ProfessorDataSource,
    private val cacheDataSource: ProfessorDataSource? = null
) : ProfessorRDS {

    override suspend fun findById(id: Int): Professor? {
        return cacheDataSource?.findById(id) ?: mainDataSource.findById(id)
    }

    override suspend fun save(entity: Professor): Int {
        return mainDataSource.save(entity).also {
            cacheDataSource?.save(entity.copy(id = it))
        }
    }

    override suspend fun save(entities: List<Professor>): List<Int> {
        return mainDataSource.save(entities).also {

            cacheDataSource?.run {
                val savedList = entities.mapIndexed { index, entity ->
                    entity.copy(id = it[index])
                }
                save(savedList)
            }
        }
    }

    override suspend fun update(entity: Professor) {
        return mainDataSource.update(entity).also {
            cacheDataSource?.update(entity)
        }
    }

    override suspend fun delete(id: Int) {
        return mainDataSource.delete(id).also {
            cacheDataSource?.delete(id)
        }
    }

    override suspend fun deleteAll() {
        cacheDataSource?.deleteAll()
        mainDataSource.deleteAll()
    }

    override suspend fun findAll(): List<Professor> {
        return try {
            mainDataSource.findAll().also {
                cacheDataSource?.deleteAll()
                cacheDataSource?.save(it)
            }
        } catch (e: Throwable) {
            cacheDataSource?.findAll() ?: throw e
        }
    }

    override suspend fun findAll(dataLimit: ProfessorRDS.DataLimit): List<Professor> {
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