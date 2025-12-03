package dev.yukado.quarkus.resource

import dev.yukado.quarkus.dto.OrderDTO
import dev.yukado.quarkus.service.OrderService
import jakarta.annotation.security.RolesAllowed
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/api/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class OrderResource {

    @Inject
    lateinit var orderService: OrderService

    @GET
    @RolesAllowed("admin")
    fun getAll(): List<OrderDTO> = orderService.findAll()

    @GET
    @Path("/{id}")
    fun getById(@PathParam("id") id: Long): OrderDTO =
        orderService.findById(id) ?: throw NotFoundException("Order $id not found")

    @GET
    @Path("/user/{userId}")
    fun getByUser(@PathParam("userId") userId: Long): List<OrderDTO> =
        orderService.findByUser(userId)

    @POST
    fun create(orderDTO: OrderDTO): Response {
        val created = orderService.create(orderDTO)
        return Response.status(Response.Status.CREATED).entity(created).build()
    }

    @PUT
    @Path("/{id}/ship")
    @RolesAllowed("admin")
    fun markAsShipped(@PathParam("id") id: Long): Response {
        return if (orderService.markAsShipped(id)) {
            Response.noContent().build()
        } else {
            throw NotFoundException("Order $id not found")
        }
    }
}
