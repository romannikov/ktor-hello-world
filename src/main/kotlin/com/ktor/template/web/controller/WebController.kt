package com.ktor.template.web.controller

import io.ktor.routing.Routing

interface WebController {
    fun routes(routing: Routing)
}
