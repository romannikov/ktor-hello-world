package com.ktor.template

import com.google.inject.Guice
import com.ktor.template.migration.MigrationHandler
import com.ktor.template.repository.module.DbModule
import com.ktor.template.service.ServiceModule
import com.ktor.template.web.WebModule
import com.ktor.template.web.WebStarter

fun main() {
    val injector = Guice.createInjector(
        listOf(
            DbModule(),
            WebModule(),
            ServiceModule()
        )
    )
    injector.getInstance(MigrationHandler::class.java).migrate()
    injector.getInstance(WebStarter::class.java).start()
}
