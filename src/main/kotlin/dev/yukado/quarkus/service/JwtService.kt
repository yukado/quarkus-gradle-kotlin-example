package dev.yukado.quarkus.service

import dev.yukado.quarkus.model.User
import io.smallrye.jwt.build.Jwt
import java.time.Duration

class JwtService {
    fun generateToken(user: User): String {
        return Jwt.issuer("example-app")
            .subject(user.email)
            .groups(user.roles) // direkt das Set<String> übergeben
            .expiresIn(Duration.ofHours(2)) // Token läuft in 2 Stunden ab
            .sign()
    }
}