package dev.yukado.quarkus.repository

import dev.yukado.quarkus.model.Order
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import java.time.LocalDateTime

@ApplicationScoped
class OrderRepository : PanacheRepository<Order> {

    fun findByUserId(userId: Long): List<Order> =
        list("userId", userId)

    fun findUnshipped(): List<Order> =
        list("shipped", false)

    fun findShipped(): List<Order> =
        list("shipped", true)

    fun findByDateRange(start: LocalDateTime, end: LocalDateTime): List<Order> =
        list("createdAt between ?1 and ?2", start, end)

    fun calculateTotalForUser(userId: Long): Double =
        find("userId", userId).list().sumOf { it.total }

    fun markAsShipped(orderId: Long): Boolean {
        val order = findById(orderId)
        return if (order != null) {
            order.shipped = true
            persist(order)
            true
        } else {
            false
        }
    }
}
