package dev.alxminyaev.feature.user.usecase.student

import com.alxminyaev.tool.error.exceptions.NotFoundException
import dev.alxminyaev.feature.user.model.*
import dev.alxminyaev.feature.user.repository.ProfessorRepository
import dev.alxminyaev.feature.user.repository.StudentRepository

class GetStudentByIdUseCase(
    private val studentRepository: StudentRepository,
) {
    suspend fun invoke(
        id: Long
    ): Student {
        return studentRepository.findById(id) ?: throw NotFoundException()
    }
}