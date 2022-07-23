object Versions {
    const val kotlin = "1.7.10"
    const val springBoot = "2.7.1"
    const val springTx = "5.3.22"
    const val dependencyManagement = "1.0.11.RELEASE"
    const val postgress = "42.4.0"
    const val jooqVersion = "3.14.16"
    const val jackson = "2.13.2"
    const val flyway = "9.0.1"
}


object Deps {
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    const val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val jackson = "com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.jackson}"
    const val postgres = "org.postgresql:postgresql:${Versions.postgress}"
    const val flywayCore = "org.flywaydb:flyway-core:${Versions.flyway}"

    object Spring {
        const val springTx = "org.springframework:spring-tx:${Versions.springTx}"
        const val springBootStarterWeb = "org.springframework.boot:spring-boot-starter-web:${Versions.springBoot}"
        const val springBootStarterJooq = "org.springframework.boot:spring-boot-starter-jooq:${Versions.springBoot}"
        const val springBootStarterTest = "org.springframework.boot:spring-boot-starter-test:${Versions.springBoot}"
        const val springBootDevTools = "org.springframework.boot:spring-boot-devtools:${Versions.springBoot}"
    }

    object Jooq {
        const val jooq = "org.jooq:jooq:${Versions.jooqVersion}"
        const val jooqMeta = "org.jooq:jooq-meta:${Versions.jooqVersion}"
        const val jooqCodeGen = "org.jooq:jooq-codegen:${Versions.jooqVersion}"
    }
}