package dev.yukado.quarkus.service

import dev.yukado.quarkus.dto.ProductDTO
import dev.yukado.quarkus.mapper.toDTO
import dev.yukado.quarkus.model.Product
import dev.yukado.quarkus.repository.ProductRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
class ProductService {

    @Inject
    lateinit var productRepository: ProductRepository

    fun findAll(): List<ProductDTO> =
        productRepository.listAll().map { it.toDTO() }

    fun findById(id: Long): ProductDTO? =
        productRepository.findById(id)?.toDTO()

    @Transactional
    fun create(product: Product): ProductDTO {
        productRepository.persist(product)
        return product.toDTO()
    }

    @Transactional
    fun update(id: Long, updated: Product): ProductDTO? {
        val product = productRepository.findById(id) ?: return null
        product.name = updated.name
        product.description = updated.description
        product.price = updated.price
        product.currency = updated.currency
        product.tags = updated.tags.toMutableSet()
        product.available = updated.available
        return product.toDTO()
    }

    @Transactional
    fun delete(id: Long): Boolean =
        productRepository.deleteById(id)
}
