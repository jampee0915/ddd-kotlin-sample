package com.example.infra.jooq

import org.jooq.codegen.DefaultGeneratorStrategy
import org.jooq.codegen.GenerationTool
import org.jooq.codegen.GeneratorStrategy
import org.jooq.meta.Definition
import org.jooq.meta.jaxb.Configuration
import org.jooq.meta.jaxb.Database
import org.jooq.meta.jaxb.ForcedType
import org.jooq.meta.jaxb.Generate
import org.jooq.meta.jaxb.Generator
import org.jooq.meta.jaxb.Strategy
import org.jooq.meta.jaxb.Target

fun main() {
    val config = Configuration()
        .withJdbc(JdbcUtils.jooqJdbc())
        .withGenerator(generator())

    GenerationTool.generate(config)
}

private fun generator(): Generator {
    return Generator()
        .withName("org.jooq.codegen.KotlinGenerator")
        .withGenerate(generate())
        .withDatabase(database())
        // .withStrategy(strategy())
        .withTarget(target())
}

private fun generate(): Generate {
    return Generate()
        .withFluentSetters(true)
//        .withImmutablePojos(true)
//        .withPojosEqualsAndHashCode(true)
//        .withSerializablePojos(true)
}

private fun database(): Database {
    return Database()
        .withInputSchema(JdbcUtils.DB_SCHEMA)
        .withExcludes("flyway_schema_history")
        .withOutputSchemaToDefault(true)
        // .withForcedTypes(forcedType())
}

private fun forcedType(): ForcedType {
    return ForcedType()
        .withName("BOOLEAN")
        .withIncludeTypes("TINYINT\\(1\\)")
}

private fun strategy(): Strategy {
    return Strategy()
        .withName(JooqGeneratorStrategy::class.java.name)
}

private fun target(): Target {
    val jooqCodeProjectName = "ddd-jooq-codes"
    val packageName = "com.example.jooq"
    val jooqDir = ProjectUtils.getDestDir(jooqCodeProjectName)

    return Target()
        .withPackageName(packageName)
        .withDirectory(jooqDir.toString())
        .withClean(true)
}

class JooqGeneratorStrategy: DefaultGeneratorStrategy() {

    override fun getJavaClassName(definition: Definition, mode: GeneratorStrategy.Mode): String {

        val name = super.getJavaClassName(definition, mode)

        return when (mode) {
            GeneratorStrategy.Mode.POJO -> "${name}Vo"
            GeneratorStrategy.Mode.RECORD -> name
            GeneratorStrategy.Mode.DEFAULT -> "J${name}"
            else -> "J${name}"
        }
    }
}