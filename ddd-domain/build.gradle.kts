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
    // ================================================= test implementation
    testImplementation(Deps.Spring.springBootStarterTest)
}