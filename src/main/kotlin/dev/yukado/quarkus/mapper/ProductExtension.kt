package dev.yukado.quarkus.mapper

import dev.yukado.quarkus.dto.ProductDTO
import dev.yukado.quarkus.model.Product

//ProductExtension.kt
fun Product.toDTO(): ProductDTO = ProductDTO(
    id = this.id,
    name = this.name,
    description = this.description,
    price = this.price,
    currency = this.currency,
    tags = this.tags.toList(),
    available = this.available,
    createdAt = this.createdAt
)
fun ProductDTO.toEntity(): Product {
    val product = Product()
    product.id = this.id
    product.name = this.name
    product.description = this.description
    product.price = this.price
    product.currency = this.currency
    product.tags = this.tags.toMutableSet()
    product.available = this.available
    product.createdAt = this.createdAt
    return product
}
