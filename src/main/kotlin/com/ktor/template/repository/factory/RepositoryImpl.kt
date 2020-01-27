package com.ktor.template.repository.factory

import org.skife.jdbi.v2.Handle
import org.skife.jdbi.v2.TransactionIsolationLevel

interface Repository : AutoCloseable {
    fun getHandle(): Handle
    fun commit()
    fun rollback()
}

class RepositoryImpl(private val handle: Handle) : Repository {
    init {
        handle.setTransactionIsolation(TransactionIsolationLevel.READ_COMMITTED)
        handle.begin()
    }

    override fun getHandle(): Handle {
        return handle
    }

    override fun commit() {
        if (!handle.isInTransaction) {
            throw RuntimeException("Connection is not in a transaction")
        }
        handle.commit()
    }

    override fun close() {
        if (handle.isInTransaction) {
            handle.rollback()
        }
    }

    override fun rollback() {
        handle.rollback()
    }
}
