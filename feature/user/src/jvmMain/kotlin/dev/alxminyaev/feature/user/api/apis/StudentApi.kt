package dev.alxminyaev.feature.user.api.apis


import com.google.gson.Gson
import dev.alxminyaev.feature.user.api.Paths
import dev.alxminyaev.feature.user.api.models.ProfessorPostRequest
import dev.alxminyaev.feature.user.api.models.StudentPostRequest
import dev.alxminyaev.feature.user.api.models.UserCreatedResponse
import dev.alxminyaev.feature.user.usecase.professor.CreateProfessorUseCase
import dev.alxminyaev.feature.user.usecase.professor.GetProfessorByIdUseCase
import dev.alxminyaev.feature.user.usecase.student.CreateStudentUseCase
import dev.alxminyaev.feature.user.usecase.student.GetStudentByIdUseCase
import dev.alxminyaev.tool.webServer.utils.User
import dev.alxminyaev.tool.webServer.utils.UserType
import dev.alxminyaev.tool.webServer.utils.user
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.kodein.di.instance
import org.kodein.di.ktor.di

@KtorExperimentalLocationsAPI
fun Route.StudentApi() {
    val gson = Gson()
    val empty = mutableMapOf<String, Any?>()

    delete<Paths.deleteStudentById> { _: Paths.deleteStudentById ->
        call.respond(HttpStatusCode.NotImplemented)

    }


    get { pathParams: Paths.getStudentById ->
        val user = call.user
        when {
            user != null && (user.userType == UserType.PROFESSOR || user.userType == UserType.TUTOR
                    || (user.userType == UserType.STUDENT && user.id == pathParams.id)) -> {

                val getStudentUseCase by di().instance<GetStudentByIdUseCase>()
                val student = getStudentUseCase.invoke(pathParams.id)
                call.respond(student)
            }
            else -> call.respond(HttpStatusCode.Forbidden)
        }

    }


    route("/api/v1/student") {
        post {
            val requestBody = call.receive<StudentPostRequest>()
            val createNewUserUseCase by di().instance<CreateStudentUseCase>()
            val userId = createNewUserUseCase.invoke(
                login = requestBody.account.login,
                password = requestBody.account.password,
                repeatPassword = requestBody.account.repeatPassword,
                firstName = requestBody.profile.firstName,
                lastName = requestBody.profile.lastName,
                middleName = requestBody.profile.middleName
            )
            call.respond(UserCreatedResponse(id = userId))

        }
    }


    route("/api/v1/student/{id}") {
        put {
            call.respond(HttpStatusCode.NotImplemented)

        }
    }

}
