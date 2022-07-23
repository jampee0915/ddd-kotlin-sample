// ===================================================================================
//                                                                             plugins
//                                                                             =======
plugins {
    id("io.spring.dependency-management")
    id("org.flywaydb.flyway") version Versions.flyway
}


// ===================================================================================
//                                                                        dependencies
//                                                                        ============
dependencies {
    implementation(Deps.flywayCore)
    runtimeOnly(Deps.postgres)
}


// ===================================================================================
//                                                                              flyway
//                                                                              ======
flyway {
    url = System.getenv("DB_URL") ?: "jdbc:postgresql://localhost:5433/ddddb?currentSchema=ddd"
    user = System.getenv("DB_USER") ?: "ddduser"
    password = System.getenv("DB_PASSWORD") ?: "passw0rd"
}
