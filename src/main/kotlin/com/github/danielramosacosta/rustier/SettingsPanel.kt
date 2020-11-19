package com.github.danielramosacosta.rustier

import javax.swing.*

class SettingsPanel {
    private var rootPanel: JPanel? = null
    private var rustfmtPathComboBox: JComboBox<*>? = null
    private var rustfmtPathOpenBrowseDialog: JButton? = null
    private var runForFilesTextField: JTextField? = null

    val panel: JComponent? get() = rootPanel
}
