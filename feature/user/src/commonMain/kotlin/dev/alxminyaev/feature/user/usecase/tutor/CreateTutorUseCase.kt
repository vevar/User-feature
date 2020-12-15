package dev.alxminyaev.feature.user.usecase.tutor

import dev.alxminyaev.feature.user.model.Account
import dev.alxminyaev.feature.user.model.Profile
import dev.alxminyaev.feature.user.model.Tutor
import dev.alxminyaev.feature.user.repository.TutorRepository

class CreateTutorUseCase(
    private val tutorRepository: TutorRepository,
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

//        val account = Account(login, password)
//        val profile = Profile(firstName = firstName, middleName = middleName, lastName = lastName)
//        val tutor = Tutor(0, profile, account)
//
//        return tutorRepository.save(tutor)
        TODO()
    }
}