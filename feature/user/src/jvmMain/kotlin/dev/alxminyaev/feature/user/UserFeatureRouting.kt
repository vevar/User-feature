package dev.alxminyaev.feature.user

import com.alxminyaev.tool.error.exceptions.PermissionException
import dev.alxminyaev.feature.user.api.apis.ProfessorApi
import dev.alxminyaev.feature.user.api.apis.StudentApi
import dev.alxminyaev.feature.user.api.apis.TutorApi
import dev.alxminyaev.feature.user.api.apis.UserApi
import dev.alxminyaev.feature.user.model.Role
import dev.alxminyaev.feature.user.model.User
import dev.alxminyaev.feature.user.usecase.user.GetUserByIdUseCase
import dev.alxminyaev.tool.webServer.api.TemporaryRedirectResponse
import dev.alxminyaev.tool.webServer.utils.user
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*
import org.kodein.di.instance
import org.kodein.di.ktor.di

@KtorExperimentalLocationsAPI
fun Application.userFeatureRouting() {
    routing {
        authenticate {
            route("/app/by/role") {
                get {
                    val useCase by di().instance<GetUserByIdUseCase>()
                    val user = useCase.invoke(call.user.id)
                    val redirectPath = when {
                        user.roles.contains(Role.ADMIN) -> "/admin/"
                        else -> throw PermissionException()
                    }
                    call.respond(TemporaryRedirectResponse(location = redirectPath))
                }
            }
        }

        route("/user") {
            UserApi()
            TutorApi()
            StudentApi()
            ProfessorApi()
        }
    }

}
