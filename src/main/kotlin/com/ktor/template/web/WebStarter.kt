package com.ktor.template.web

import com.google.inject.Inject
import com.ktor.template.config.AppConfigProvider
import com.ktor.template.service.UserService
import com.ktor.template.service.jwt.JwtProvider
import com.ktor.template.web.controller.WebController
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.jwt.jwt
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

class WebStarter @Inject constructor(
    private val controllers: Set<@JvmSuppressWildcards WebController>,
    private val userService: UserService,
    private val appConfigProvider: AppConfigProvider
) {
    fun start() {
        embeddedServer(
            Netty,
            host = appConfigProvider.config.server.host,
            port = appConfigProvider.config.server.port,
            module = module()
        ).start(wait = true)
    }

    private fun module(): Application.() -> Unit {
        return {
            install(CallLogging)
            install(ContentNegotiation) {
                jackson {
                }
            }
            install(Authentication) {
                jwt {
                    verifier(JwtProvider.verifier)
                    authSchemes("Token")
                    validate { credential ->
                        if (credential.payload.audience.contains(JwtProvider.audience)) {
                            userService.getUser(credential.payload.claims["email"]?.asString())
                        } else null
                    }
                }
            }
            routing {
                controllers.forEach { it.routes(this) }
            }
        }
    }
}
