// ===================================================================================
//                                                                             plugins
//                                                                             =======
plugins {
    kotlin("jvm") version Versions.kotlin
    kotlin("plugin.spring") version Versions.kotlin
    id("org.springframework.boot") version Versions.springBoot
    id("io.spring.dependency-management") version Versions.dependencyManagement
}


// ===================================================================================
//                                                                         allProjects
//                                                                         ===========
// すべてのプロジェクトで共通の特性(プロパティ・タスク)を定義する
allprojects {
    group = App.group
    version = App.version

    repositories {
        mavenCentral()
    }
}


// ===================================================================================
//                                                                         subprojects
//                                                                         ===========
// サブプロジェクトで共通の特性(プロパティ・タスク)を定義する
subprojects {
    // ================================================= plugins
    apply(plugin = "java")
    apply(plugin = "kotlin")

    java.sourceCompatibility = JavaVersion.VERSION_17

    // ================================================= dependencies
    dependencies {
        implementation(Deps.kotlinReflect)
        implementation(Deps.stdlibJdk8)
    }

    // ================================================= tasks
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}