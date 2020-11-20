package com.github.danielramosacosta.rustier

import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import java.awt.event.ActionEvent
import javax.swing.*

/*fun JComboBox<String>.setLastItem() {
}*/

class SettingsPanel(val settingsStateService: RustfmtStateService) {
    private var rootPanel: JPanel? = null
    private var rustfmtPathComboBox: JComboBox<String>? = null
    private var rustfmtPathOpenBrowseDialog: JButton? = null
    private var runForFilesTextField: JTextField? = null
    val panel: JComponent? get() = rootPanel

    init {
        rustfmtPathOpenBrowseDialog?.let {
            it.addActionListener(this::onOpenRustfmtPathBrowserButtonClicked)
        }

        this.pathsToComboBox(settingsStateService.getRustfmtAvailablePaths())
        // TODO: use intellij combobox
        rustfmtPathComboBox?.isEditable = true
    }

    fun onOpenRustfmtPathBrowserButtonClicked(it: ActionEvent) {
        println("clicked!")
        val fileChooserDescriptor = FileChooserDescriptor(
                true,
                false,
                false,
                false,
                false,
                false
        )
        val file = FileChooser.chooseFile(fileChooserDescriptor, rootPanel, null, null)

        file?.let { file ->
            val path = file.path
            println(path)
            settingsStateService.setCustomUserPath(path)
            pathsToComboBox(settingsStateService.getRustfmtAvailablePaths())
        }
    }

    fun pathsToComboBox(paths: List<String>) {
        rustfmtPathComboBox?.let { comboBox ->
            comboBox.removeAll()

            paths.forEach { path ->
                comboBox.addItem(path)
            }

            comboBox.selectedIndex = 0
        }
    }
}
