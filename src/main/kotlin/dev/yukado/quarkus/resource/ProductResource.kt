package dev.yukado.quarkus.resource

import dev.yukado.quarkus.dto.ProductDTO
import dev.yukado.quarkus.model.Product
import dev.yukado.quarkus.service.ProductService
import jakarta.annotation.security.RolesAllowed
import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.NotFoundException
import jakarta.ws.rs.POST
import jakarta.ws.rs.PUT
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/api/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class ProductResource {

    @Inject
    lateinit var productService: ProductService

    @GET
    fun getAll(): List<ProductDTO> = productService.findAll()

    @GET
    @Path("/{id}")
    fun getById(@PathParam("id") id: Long): ProductDTO =
        productService.findById(id) ?: throw NotFoundException("Product $id not found")

    @POST
    @RolesAllowed("admin")
    fun create(product: Product): Response {
        val created = productService.create(product)
        return Response.status(Response.Status.CREATED).entity(created).build()
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("admin")
    fun update(@PathParam("id") id: Long, updated: Product): ProductDTO =
        productService.update(id, updated) ?: throw NotFoundException("Product $id not found")

    @DELETE
    @Path("/{id}")
    @RolesAllowed("admin")
    fun delete(@PathParam("id") id: Long): Response {
        if (productService.delete(id)) {
            return Response.noContent().build()
        }
        throw NotFoundException("Product $id not found")
    }
}