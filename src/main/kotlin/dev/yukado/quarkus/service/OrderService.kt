package dev.yukado.quarkus.service

import dev.yukado.quarkus.dto.OrderDTO
import dev.yukado.quarkus.mapper.toDTO
import dev.yukado.quarkus.model.Order
import dev.yukado.quarkus.repository.OrderRepository
import dev.yukado.quarkus.repository.ProductRepository
import dev.yukado.quarkus.repository.UserRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
class OrderService {

    @Inject
    lateinit var orderRepository: OrderRepository

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var productRepository: ProductRepository

    fun findAll(): List<OrderDTO> =
        orderRepository.listAll().map { it.toDTO() }

    fun findByUser(userId: Long): List<OrderDTO> =
        orderRepository.find("user.id", userId).list().map { it.toDTO() }

    fun findById(id: Long): OrderDTO? =
        orderRepository.findById(id)?.toDTO()

    @Transactional
    fun create(dto: OrderDTO): OrderDTO {
        val order = Order()
        order.user = dto.userId?.let { userRepository.findById(it) } ?: throw IllegalArgumentException("User not found")
        order.products = dto.productIds.mapNotNull { productRepository.findById(it) }.toMutableList()
        order.total = dto.total
        order.shipped = dto.shipped
        orderRepository.persist(order)
        return order.toDTO()
    }

    @Transactional
    fun markAsShipped(id: Long): Boolean {
        val order = orderRepository.findById(id) ?: return false
        order.shipped = true
        return true
    }
}
