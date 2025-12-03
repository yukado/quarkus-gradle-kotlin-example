package dev.yukado.quarkus.resource

import dev.yukado.quarkus.dto.LoginDTO
import dev.yukado.quarkus.service.JwtService
import dev.yukado.quarkus.service.RegisterService
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

// REST-Endpunkt für Login
@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class AuthResource {

    private val registerService = RegisterService()
    private val jwtService = JwtService()

    @POST
    @Path("/login")
    fun login(dto: LoginDTO): Response {
        val user = registerService.validate(dto)
        val token = jwtService.generateToken(user)
        return Response.ok(mapOf("access_token" to token)).build()
    }
}
