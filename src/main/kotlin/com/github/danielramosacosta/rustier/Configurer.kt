package com.github.danielramosacosta.rustier

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project
import javax.swing.JComponent

class Configurer(private val project: Project) : Configurable {

    private var settingsStateService = RustfmtStateService.getInstance(project)

    private val settingsPanel: SettingsPanel by lazy {
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
        settingsStateService.setCustomUserPath(settingsPanel.getUserDefinedPath())
    }

    override fun createComponent(): JComponent? {
        return settingsPanel.panel
    }
}
