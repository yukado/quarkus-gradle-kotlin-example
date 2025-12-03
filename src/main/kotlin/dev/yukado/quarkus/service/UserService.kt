package dev.yukado.quarkus.service

import dev.yukado.quarkus.dto.UserDTO
import dev.yukado.quarkus.mapper.toDTO
import dev.yukado.quarkus.model.User
import dev.yukado.quarkus.repository.UserRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
class UserService {

    @Inject
    lateinit var userRepository: UserRepository

    fun findAll(): List<UserDTO> =
        userRepository.listAll().map { it.toDTO() }

    fun findById(id: Long): UserDTO? =
        userRepository.findById(id)?.toDTO()

    @Transactional
    fun create(user: User): UserDTO {
        userRepository.persist(user)
        return user.toDTO()
    }

    @Transactional
    fun delete(id: Long): Boolean =
        userRepository.deleteById(id)
}
