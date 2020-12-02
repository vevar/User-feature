package dev.alxminyaev.feature.user.usecase.professor

import dev.alxminyaev.feature.user.model.*
import dev.alxminyaev.feature.user.repository.ProfessorRepository

class CreateProfessorUseCase(
    private val professorRepository: ProfessorRepository,
) {
    suspend fun invoke(
        login: String,
        password: String,
        repeatPassword: String,
        firstName: String,
        lastName: String,
        middleName: String?
    ): Int {
        // TODO MEDIUM Need validation of data


        val account = Account(login, password)
        val profile = Profile(firstName = firstName, middleName = middleName, lastName = lastName)
        val student = Professor(0, account = account, profile = profile)

        return professorRepository.save(student)
    }
}