package com.github.danielramosacosta.rustier

import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class Configurer : Configurable {
    val settingsPanel: SettingsPanel by lazy {
        SettingsPanel()
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