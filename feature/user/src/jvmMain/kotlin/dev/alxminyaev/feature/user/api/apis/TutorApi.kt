package dev.alxminyaev.feature.user.api.apis


import com.google.gson.Gson
import dev.alxminyaev.feature.user.api.Paths
import dev.alxminyaev.feature.user.api.models.StudentPostRequest
import dev.alxminyaev.feature.user.api.models.TutorPostRequest
import dev.alxminyaev.feature.user.api.models.UserCreatedResponse
import dev.alxminyaev.feature.user.usecase.professor.GetProfessorByIdUseCase
import dev.alxminyaev.feature.user.usecase.student.CreateStudentUseCase
import dev.alxminyaev.feature.user.usecase.tutor.CreateTutorUseCase
import dev.alxminyaev.feature.user.usecase.tutor.GetTutorByIdUseCase
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.kodein.di.instance
import org.kodein.di.ktor.di

@KtorExperimentalLocationsAPI
fun Route.TutorApi() {
    val gson = Gson()
    val empty = mutableMapOf<String, Any?>()

    delete<Paths.deleteTutorById> { _: Paths.deleteTutorById ->
        call.respond(HttpStatusCode.NotImplemented)

    }


    get<Paths.getTutorById> { pathParams ->
        val getTutorByIdUseCase by di().instance<GetTutorByIdUseCase>()
        val professor = getTutorByIdUseCase.invoke(pathParams.id)
        call.respond(professor)
    }


    route("/api/v1/tutor") {
        post {
            val requestBody = call.receive<TutorPostRequest>()
            val createNewUserUseCase by di().instance<CreateTutorUseCase>()
            val userId = createNewUserUseCase.invoke(
                login = requestBody.account.login,
                password = requestBody.account.password,
                repeatPassword = requestBody.account.repeatPassword,
                firstName = requestBody.profile.firstName,
                lastName = requestBody.profile.lastName,
                middleName = requestBody.profile.middleName
            )
            call.respond(UserCreatedResponse(id = userId.toLong()))
        }
    }


    route("/api/v1/tutor/{id}") {
        put {
            call.respond(HttpStatusCode.NotImplemented)

        }
    }

}
