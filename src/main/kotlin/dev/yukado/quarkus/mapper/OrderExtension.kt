package dev.yukado.quarkus.mapper

import dev.yukado.quarkus.model.Product
import dev.yukado.quarkus.model.User
import dev.yukado.quarkus.dto.OrderDTO
import dev.yukado.quarkus.model.Order
//OrderExtension.kt
fun Order.toDTO(): OrderDTO = OrderDTO(
    id = this.id,
    userId = this.user.id,
    productIds = this.products.mapNotNull { it.id },
    total = this.total,
    shipped = this.shipped,
    createdAt = this.createdAt
)

fun OrderDTO.toEntity(user: User, products: List<Product>): Order {
    val order = Order()
    order.id = this.id
    order.user = user
    order.products = products.toMutableList()
    order.total = this.total
    order.shipped = this.shipped
    order.createdAt = this.createdAt
    return order
}

