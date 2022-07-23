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
    implementation(Deps.Spring.springTx)

    // ================================================= test implementation
    testImplementation(Deps.Spring.springBootStarterTest)

    // ================================================= project implementation
    implementation(project(":${Project.dddDomain}"))
}