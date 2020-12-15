package dev.alxminyaev.feature.user

import dev.alxminyaev.feature.user.api.apis.ProfessorApi
import dev.alxminyaev.feature.user.api.apis.StudentApi
import dev.alxminyaev.feature.user.api.apis.TutorApi
import dev.alxminyaev.feature.user.api.apis.UserApi
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.locations.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
fun Application.userFeatureRouting() {
    routing {
        route("/user") {
            UserApi()
            TutorApi()
            StudentApi()
            ProfessorApi()
        }
    }

}
