// ===================================================================================
//                                                                             plugins
//                                                                             =======
plugins {
    application
}


// ===================================================================================
//                                                                        dependencies
//                                                                        ============
dependencies {
    // ================================================= implementation
    implementation(Deps.Jooq.jooq)
    implementation(Deps.Jooq.jooqMeta)
    implementation(Deps.Jooq.jooqCodeGen)

    // ================================================= runtimeOnly
    runtimeOnly(Deps.postgres)
}


// ===================================================================================
//                                                                                task
//                                                                                ====
// NOTE: ./gradlew :jooq-gen:cleanCode をするための設定
// hire-jooq-codesに生成されたjooqコードを削除するタスク
task("cleanCode", Delete::class) {
    delete = setOf("${rootProject.projectDir}/${Project.dddJooqCodes}/src")
}

// NOTE: ./gradlew :jooq-gen:run をするための設定
// hire-jooq-codesにjooqコードを生成するタスク
application {
    mainClass.set("com.example.infra.jooq.JooqGeneratorKt")
}