package com.ktor.template.repository

import com.google.inject.Inject
import com.ktor.template.repository.factory.RepositoryFactory

class UserRepository @Inject constructor(private val repositoryFactory: RepositoryFactory) {
//    fun login(email: String, password: String): User? {
//        val signInSql = "SELECT id, email, name, password FROM users WHERE " +
//                "email = :email AND " +
//                "password = CAST(digest(salt||:password, 'sha256') AS TEXT)"
//        repositoryFactory.getRepository().use { repository ->
//            return repository.getHandle().createQuery(signInSql)
//                    .bind("email", email)
//                    .bind("password", password)
//                    .map { _, r, _ ->
//                        User(r.getLong("id"), r.getString("name"), r.getString("email"))
//                    }
//                    .firstOrNull()
//        }
//    }
//
//    fun create(name: String, email: String, password: String): User {
//        val createSql = """WITH x AS (SELECT CAST(GEN_SALT('bf') AS TEXT) as salt)
//            INSERT INTO users (email, name, password, salt, updated_at, created_at)
//            SELECT :email, :name, CAST(digest(salt||:password, 'sha256') AS TEXT), salt, NOW(), NOW()
//            FROM x RETURNING id""".trimIndent()
//
//        repositoryFactory.getRepository().use { repository ->
//            val id = repository.getHandle().createQuery(createSql)
//                    .bind("email", email)
//                    .bind("name", name)
//                    .bind("password", password)
//                    .map { _, r, _ -> r.getLong("id") }
//                    .first()
//            repository.commit()
//            return User(id, name, email)
//        }
//    }
}
