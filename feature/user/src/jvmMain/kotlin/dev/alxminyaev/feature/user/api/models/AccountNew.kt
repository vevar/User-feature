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
package dev.alxminyaev.feature.user.api.models


/**
 * 
 * @param login 
 * @param password 
 * @param repeatPassword 
 */
data class AccountNew (
    val login: kotlin.String,
    val password: kotlin.String,
    val repeatPassword: kotlin.String
) 

