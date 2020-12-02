package dev.alxminyaev.feature.user.usecase.professor

import com.alxminyaev.tool.error.exceptions.NotFoundException
import dev.alxminyaev.feature.user.model.*
import dev.alxminyaev.feature.user.repository.ProfessorRepository

class GetProfessorByIdUseCase(
    private val professorRepository: ProfessorRepository,
) {
    suspend fun invoke(
        id: Int
    ): Professor {
        return professorRepository.findById(id) ?: throw NotFoundException()
    }
}