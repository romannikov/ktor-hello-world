package com.ktor.template.repository.factory

import com.google.inject.Inject
import org.skife.jdbi.v2.DBI

interface RepositoryFactory {
    fun getRepository(): Repository
}

class RepositoryFactoryImpl @Inject constructor(private val dataSourceProvider: DataSourceProvider) : RepositoryFactory {
    override fun getRepository(): Repository {
        val dbi = DBI(dataSourceProvider.dataSource)
        return RepositoryImpl(dbi.open())
    }
}
