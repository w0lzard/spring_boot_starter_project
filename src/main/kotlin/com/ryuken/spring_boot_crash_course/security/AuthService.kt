package com.ryuken.spring_boot_crash_course.security

import com.ryuken.spring_boot_crash_course.database.repository.UserRepository
import com.ryuken.spring_boot_crash_course.model.User
import org.springframework.stereotype.Service

@Service

class AuthService (
    private val jwtService: JWTService,
    private val userRepository: UserRepository,
    private val hashEncoder: HashEncoder
) {
    fun register(email: String, password: String): User {

    }
}