package com.github.danielramosacosta.rustier

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project
import javax.swing.JComponent

class Configurer(private val project: Project) : Configurable {

    val settingsPanel: SettingsPanel by lazy {
        val settingsStateService = RustfmtStateService.getInstance(project)
        println("I have the super service ${settingsStateService.state.userDefinedPath}")
        SettingsPanel(settingsStateService)
    }

    override fun isModified(): Boolean {
        print("[isModified] TODO xd")

        return true
    }

    override fun getDisplayName(): String {
        return "Rustier"
    }

    override fun apply() {
        print("[apply] TODO xd")
    }

    override fun createComponent(): JComponent? {
        return settingsPanel.panel
    }
}