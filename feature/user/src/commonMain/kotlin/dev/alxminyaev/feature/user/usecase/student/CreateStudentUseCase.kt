package dev.alxminyaev.feature.user.usecase.student

import dev.alxminyaev.feature.user.model.Account
import dev.alxminyaev.feature.user.model.Profile
import dev.alxminyaev.feature.user.model.Student
import dev.alxminyaev.feature.user.model.Tutor
import dev.alxminyaev.feature.user.repository.StudentRepository

class CreateStudentUseCase(
    private val studentRepository: StudentRepository,
) {
    suspend fun invoke(
        login: String,
        password: String,
        repeatPassword: String,
        firstName: String,
        lastName: String,
        middleName: String?
    ): Long {

        // TODO MEDIUM Need validation of data

        val student = Student(0)

        return studentRepository.save(student)
    }
}