package com.github.danielramosacosta.rustier.services

import com.intellij.openapi.project.Project
import com.github.danielramosacosta.rustier.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
