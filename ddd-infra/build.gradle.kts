// ===================================================================================
//                                                                             plugins
//                                                                             =======
plugins {
    kotlin("plugin.spring")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}


// ===================================================================================
//                                                                        dependencies
//                                                                        ============
dependencies {
    // ================================================= implementation
    implementation(Deps.Spring.springBootStarterWeb)
    implementation(Deps.Spring.springBootStarterJooq)
    implementation(Deps.Jooq.jooq)

    // ================================================= project implementation
    implementation(project(":${Project.dddDomain}"))
    implementation(project(":${Project.dddJooqCodes}"))

    // ================================================= runtimeOnly
    runtimeOnly(Deps.postgres)

    // ================================================= test implementation
    testImplementation(Deps.Spring.springBootStarterTest)
}