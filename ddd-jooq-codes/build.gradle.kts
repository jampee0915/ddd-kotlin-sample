// ===================================================================================
//                                                                        dependencies
//                                                                        ============
dependencies {
    implementation(Deps.Jooq.jooq)
}


// ===================================================================================
//                                                                                task
//                                                                                ====
val jar by tasks.getting(Jar::class) {
    // Gradle 7 requires duplicatesStrategy to be specified.
    // See more: https://github.com/gradle/gradle/issues/17236
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}