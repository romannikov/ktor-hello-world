package com.ktor.template.config;

import com.typesafe.config.ConfigBeanFactory
import com.typesafe.config.ConfigFactory

class AppConfigProvider {
    val config: AppConfig by lazy {
        val configName = if ("true" == System.getenv("PRODUCTION")) "application-prod.conf" else "application.conf"
        ConfigBeanFactory.create(ConfigFactory.load(configName).getConfig("app"), AppConfig::class.java)
    }
}

data class Server(var host: String = "", var port: Int = 0)
data class Db(var url: String = "", var username: String = "", var password: String = "", var maxPoolSize: Int = 0)
data class AppConfig(var server: Server = Server(), var db: Db = Db())
