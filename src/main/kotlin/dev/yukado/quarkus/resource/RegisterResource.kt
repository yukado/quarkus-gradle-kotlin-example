package dev.yukado.quarkus.resource

import dev.yukado.quarkus.dto.RegisterDTO
import dev.yukado.quarkus.service.RegisterService
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class RegisterResource {

    private val registerService = RegisterService()

    @POST
    @Path("/register")
    fun register(dto: RegisterDTO): Response {
        registerService.register(dto)
        return Response.status(Response.Status.CREATED).build()
    }
}
