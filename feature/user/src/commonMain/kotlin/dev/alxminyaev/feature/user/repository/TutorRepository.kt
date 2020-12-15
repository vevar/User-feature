package dev.alxminyaev.feature.user.repository

import dev.alxminyaev.feature.user.datasource.TutorDataSource
import dev.alxminyaev.feature.user.model.Tutor
import dev.alxminyaev.feature.user.rds.TutorRDS


class TutorRepository(
    private val mainDataSource: TutorDataSource,
    private val cacheDataSource: TutorDataSource? = null
) : TutorRDS {

    override suspend fun findById(id: Long): Tutor? {
        return cacheDataSource?.findById(id) ?: mainDataSource.findById(id)
    }

    override suspend fun save(entity: Tutor): Long {
        return mainDataSource.save(entity).also {
            cacheDataSource?.save(entity.copy(id = it))
        }
    }

    override suspend fun save(entities: List<Tutor>): List<Long> {
        return mainDataSource.save(entities).also {

            cacheDataSource?.run {
                val savedList = entities.mapIndexed { index, entity ->
                    entity.copy(id = it[index])
                }
                save(savedList)
            }
        }
    }

    override suspend fun update(entity: Tutor) {
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

    override suspend fun findAll(): List<Tutor> {
        return try {
            mainDataSource.findAll().also {
                cacheDataSource?.deleteAll()
                cacheDataSource?.save(it)
            }
        } catch (e: Throwable) {
            cacheDataSource?.findAll() ?: throw e
        }
    }

    override suspend fun findAll(dataLimit: TutorRDS.DataLimit): List<Tutor> {
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