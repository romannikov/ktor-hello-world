package com.ktor.template.service

import com.google.inject.AbstractModule
import com.google.inject.Singleton

class ServiceModule : AbstractModule() {
    override fun configure() {
        bind(UserService::class.java).to(UserServiceImpl::class.java).`in`(Singleton::class.java)
    }
}
