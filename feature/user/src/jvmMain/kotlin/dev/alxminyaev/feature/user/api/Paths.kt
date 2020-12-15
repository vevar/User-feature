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
package dev.alxminyaev.feature.user.api

import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location

object Paths {
    /**
     * Get professor by id 
     * 
     * @param id ID of object to return 
     */
    @KtorExperimentalLocationsAPI
    @Location("/api/v1/professor/{id}") class getProfessorById(val id: kotlin.Int)

    /**
     * Get roles
     * 
     */
    @KtorExperimentalLocationsAPI
    @Location("/api/v1/role") class getRole()

    /**
     * Get student by id 
     * 
     * @param id ID of object to return 
     */
    @KtorExperimentalLocationsAPI
    @Location("/api/v1/student/{id}") class getStudentById(val id: kotlin.Long)

    /**
     * Get tutor by id 
     * 
     * @param id ID of object to return 
     */
    @KtorExperimentalLocationsAPI
    @Location("/api/v1/tutor/{id}") class getTutorById(val id: kotlin.Int)

    /**
     * Update user
     * 
     * @param id ID of object to return 
     */
    @KtorExperimentalLocationsAPI
    @Location("/api/v1/user/{id}") class deleteUser(val id: kotlin.Long)

    /**
     * Get users
     * 
     * @param offset The number of items to skip before starting to collect the result set 
     * @param limit The numbers of items to return 
     * @param roles  (optional)
     */
    @KtorExperimentalLocationsAPI
    @Location("/api/v1/user") class getUsers(val offset: kotlin.Long, val limit: kotlin.Int, val roles: kotlin.Array<kotlin.Int>? = null)

}
