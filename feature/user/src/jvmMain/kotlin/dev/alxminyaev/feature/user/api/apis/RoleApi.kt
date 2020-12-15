/**
* User service
* User service
*
* The version of the OpenAPI document: 1.0.0
* Contact: alxminyaev@gmail.com
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package dev.alxminyaev.feature.user.api.apis


import com.google.gson.Gson
import dev.alxminyaev.feature.user.api.Paths
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
fun Route.RoleApi() {
    val gson = Gson()
    val empty = mutableMapOf<String, Any?>()

    get<Paths.getRole> {  _: Paths.getRole ->
        val exampleContentType = "application/json"
val exampleContentString = """{
          "data" : [ {
            "name" : "name",
            "id" : 0
          }, {
            "name" : "name",
            "id" : 0
          } ]
        }"""

when(exampleContentType) {
    "application/json" -> call.respond(gson.fromJson(exampleContentString, empty::class.java))
    "application/xml" -> call.respondText(exampleContentString, ContentType.Text.Xml)
    else -> call.respondText(exampleContentString)
}

    }

}