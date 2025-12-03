package dev.yukado.quarkus.resource

import dev.yukado.quarkus.dto.UserDTO
import dev.yukado.quarkus.model.User
import dev.yukado.quarkus.service.UserService
import jakarta.annotation.security.RolesAllowed
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class UserResource {

    @Inject
    lateinit var userService: UserService

    @GET
    @RolesAllowed("admin")
    fun getAll(): List<UserDTO> = userService.findAll()

    @GET
    @Path("/{id}")
    @RolesAllowed("admin")
    fun getById(@PathParam("id") id: Long): UserDTO =
        userService.findById(id) ?: throw NotFoundException("User $id not found")

    @POST
    fun create(user: User): Response {
        val created = userService.create(user)
        return Response.status(Response.Status.CREATED).entity(created).build()
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("admin")
    fun delete(@PathParam("id") id: Long): Response {
        if (userService.delete(id)) {
            return Response.noContent().build()
        }
        throw NotFoundException("User $id not found")
    }
}
