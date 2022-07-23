package com.example.infra.jooq

import org.jooq.meta.jaxb.Jdbc

object JdbcUtils {
    private val JDBC_URL =  System.getenv("DB_URL") ?: "jdbc:postgresql://localhost:5433/ddddb"
    private val JDBC_USER =  System.getenv("DB_USER") ?: "ddduser"
    private val JDBC_PASSWORD = System.getenv("DB_PASSWORD") ?: "passw0rd"
    const val DB_SCHEMA = "ddd"

    fun jooqJdbc(): Jdbc {
        return Jdbc()
            .withDriver("org.postgresql.Driver")
            .withUrl(JDBC_URL)
            .withUser(JDBC_USER)
            .withPassword(JDBC_PASSWORD)
    }
}