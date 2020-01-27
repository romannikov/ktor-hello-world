package com.ktor.template.repository.module

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import com.ktor.template.repository.UserRepository
import com.ktor.template.repository.factory.DataSourceProvider
import com.ktor.template.repository.factory.DataSourceProviderImpl
import com.ktor.template.repository.factory.RepositoryFactory
import com.ktor.template.repository.factory.RepositoryFactoryImpl

class DbModule : AbstractModule() {
    override fun configure() {
        bind(DataSourceProvider::class.java).to(DataSourceProviderImpl::class.java).`in`(Singleton::class.java)
        bind(RepositoryFactory::class.java).to(RepositoryFactoryImpl::class.java).`in`(Singleton::class.java)


        bind(UserRepository::class.java).`in`(Singleton::class.java)
    }
}
