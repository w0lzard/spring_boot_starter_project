package com.ryuken.spring_boot_crash_course.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JWTAuthFilter(
    private val jwtService: JWTService
): OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        filterChain: FilterChain?
    ) {
        val authHeader = request.getHeader("Authorization")
    }
}