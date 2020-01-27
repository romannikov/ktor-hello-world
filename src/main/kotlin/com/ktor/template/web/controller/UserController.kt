package com.ktor.template.web.controller

import io.ktor.application.ApplicationCall
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.post

class UserController : WebController {
    override fun routes(routing: Routing) {
        routing {
            post ("/users") { register(this.context) }
        }
    }

    private suspend fun register(call: ApplicationCall) {
        call.respond(mapOf("hello" to "world"))
    }
}
