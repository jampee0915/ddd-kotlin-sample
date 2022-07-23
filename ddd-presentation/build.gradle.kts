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
	implementation(Deps.jackson)

	// ================================================= project implementation
	implementation(project(":${Project.dddUseCase}"))
	implementation(project(":${Project.dddDomain}"))

	// ================================================= runtimeOnly
	runtimeOnly(project(":${Project.dddInfra}"))

	// ================================================= developmentOnly
	developmentOnly(Deps.Spring.springBootDevTools)

	// ================================================= test implementation
	testImplementation(Deps.Spring.springBootStarterTest)
}