package dev.alxminyaev.feature.user.api.apis


import com.google.gson.Gson
import dev.alxminyaev.feature.user.api.Paths
import dev.alxminyaev.feature.user.api.models.ProfessorPostRequest
import dev.alxminyaev.feature.user.api.models.UserCreatedResponse
import dev.alxminyaev.feature.user.usecase.professor.CreateProfessorUseCase
import dev.alxminyaev.feature.user.usecase.professor.GetProfessorByIdUseCase
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.kodein.di.instance
import org.kodein.di.ktor.di

@KtorExperimentalLocationsAPI
fun Route.ProfessorApi() {
    val gson = Gson()
    val empty = mutableMapOf<String, Any?>()

    delete { _: Paths.deleteProfessorById ->
        call.respond(HttpStatusCode.NotImplemented)

    }


    get { pathParams: Paths.getProfessorById ->
        val getProfessorUseCase by di().instance<GetProfessorByIdUseCase>()
        val professor = getProfessorUseCase.invoke(pathParams.id)
        call.respond(professor)
    }


    route("/api/v1/professor") {
        post {
            val requestBody = call.receive<ProfessorPostRequest>()
            val createNewUserUseCase by di().instance<CreateProfessorUseCase>()
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


    route("/api/v1/professor/{id}") {
        put {
            call.respond(HttpStatusCode.NotImplemented)

        }
    }

}
