package com.ktor.template.web

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import com.google.inject.multibindings.Multibinder
import com.ktor.template.web.controller.UserController
import com.ktor.template.web.controller.WebController

class WebModule : AbstractModule() {
    override fun configure() {
        val binder = Multibinder.newSetBinder(binder(), WebController::class.java)
        binder.addBinding().to(UserController::class.java).`in`(Singleton::class.java)
    }
}
