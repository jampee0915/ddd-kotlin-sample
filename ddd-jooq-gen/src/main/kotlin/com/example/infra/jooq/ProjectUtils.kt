package com.example.infra.jooq

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

object ProjectUtils {

    fun getDestDir(projectName: String): Path {
        return getProjectDir(projectName).resolve("src/main/kotlin")
    }

    private fun getProjectDir(projectName: String): Path {
        var roodDir = Paths.get(".")
        if(!Files.exists(roodDir.resolve(projectName))) {
            roodDir = roodDir.resolve("..")
        }
        return roodDir.resolve(projectName)
    }
}