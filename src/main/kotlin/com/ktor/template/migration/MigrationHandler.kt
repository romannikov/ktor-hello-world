package com.ktor.template.migration

import com.google.inject.Inject
import com.ktor.template.config.AppConfigProvider

class MigrationHandler @Inject constructor(private val configProvider: AppConfigProvider) {
    fun migrate() {
//        val dbConfig = configProvider.config.db
//        val flyway = Flyway()
//        flyway.setDataSource(dbConfig.url, dbConfig.username, dbConfig.password)
//        flyway.setSchemas("public")
//        flyway.migrate()
    }
}
