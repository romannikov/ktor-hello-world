package com.ktor.template.service

import io.ktor.auth.Principal

interface UserService {
    fun getUser(email: String?): User
}

data class User(val id: Long) : Principal
