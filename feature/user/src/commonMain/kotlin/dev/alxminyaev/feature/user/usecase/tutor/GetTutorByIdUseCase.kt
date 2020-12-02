package dev.alxminyaev.feature.user.usecase.tutor

import com.alxminyaev.tool.error.exceptions.NotFoundException
import dev.alxminyaev.feature.user.model.*
import dev.alxminyaev.feature.user.repository.ProfessorRepository
import dev.alxminyaev.feature.user.repository.TutorRepository

class GetTutorByIdUseCase(
    private val tutorRepository: TutorRepository,
) {
    suspend fun invoke(
        id: Int
    ): Tutor {
        return tutorRepository.findById(id) ?: throw NotFoundException()
    }
}