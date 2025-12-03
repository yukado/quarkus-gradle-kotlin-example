package dev.yukado.quarkus.service

import dev.yukado.quarkus.dto.LoginDTO
import dev.yukado.quarkus.dto.RegisterDTO
import dev.yukado.quarkus.model.User

// Simuliert Benutzerprüfung (z. B. gegen Datenbank)
class RegisterService {
    fun validate(dto: LoginDTO): User {
        // TODO: Ersetze durch echte Validierung
        if (dto.email == "admin@example.com" && dto.password == "secret") {
            return User(1, dto.email, "admin")
        }
        throw SecurityException("Ungültige Zugangsdaten")
    }
    fun register(dto: RegisterDTO) {
        // TODO: Persistiere Benutzer in DB
        println("Registriere neuen Benutzer: ${dto.email} mit Rolle ${dto.role}")
    }

}