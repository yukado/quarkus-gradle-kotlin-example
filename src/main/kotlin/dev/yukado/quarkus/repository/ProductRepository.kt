package dev.yukado.quarkus.repository

import dev.yukado.quarkus.model.Product
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped


@ApplicationScoped
class ProductRepository : PanacheRepository<Product> {
    fun findByName(name: String): Product? {
        return find("name", name).firstResult()
    }
    fun findByTag(tag: String): List<Product> =
        list("tags", tag)

    fun findAvailable(): List<Product> =
        list("available", true)

    fun findByPriceRange(min: Double, max: Double): List<Product> =
        list("price between ?1 and ?2", min, max)

}

