package com.github.danielramosacosta.rustier

import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.ui.TextBrowseFolderListener
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.JTextField

class SettingsPanel(val rustfmtStateService: RustfmtStateService) {
    private var rootPanel: JPanel? = null
    private var runForFilesTextField: JTextField? = null
    private var textFieldWithBrowseButton: TextFieldWithBrowseButton? = null

    val panel: JComponent? get() = rootPanel

    init {
        val fileChooserDescriptor = FileChooserDescriptor(
            true,
            false,
            false,
            false,
            false,
            false
        )

        textFieldWithBrowseButton?.let {
            it.addBrowseFolderListener(TextBrowseFolderListener(fileChooserDescriptor))
            it.text = rustfmtStateService.getRusfmtPath()
        }
    }

    fun getUserDefinedPath(): String = textFieldWithBrowseButton?.text ?: rustfmtStateService.getRusfmtPath()
}
