package com.ktor.template.repository.factory

import com.google.inject.Inject
import com.ktor.template.config.AppConfigProvider
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import javax.sql.DataSource


interface DataSourceProvider {
    val dataSource: DataSource
}

class DataSourceProviderImpl @Inject constructor(private val appConfig: AppConfigProvider) : DataSourceProvider {
    override val dataSource: DataSource by lazy {
        val hikariConfig = HikariConfig()
        hikariConfig.jdbcUrl = appConfig.config.db.url
        hikariConfig.username = appConfig.config.db.username
        hikariConfig.password = appConfig.config.db.password

        hikariConfig.driverClassName = "org.postgresql.Driver"
        hikariConfig.poolName = "AppPool"
        hikariConfig.maximumPoolSize = appConfig.config.db.maxPoolSize
        hikariConfig.minimumIdle = 2
        hikariConfig.idleTimeout = 30000
        hikariConfig.connectionTimeout = 60000
        hikariConfig.addDataSourceProperty("ApplicationName", "App")
        HikariDataSource(hikariConfig)
    }
}
