package com.github.danielramosacosta.rustier.listeners

import com.github.danielramosacosta.rustier.application.RustFormatter
import com.github.danielramosacosta.rustier.domain.DocumentIO
import com.github.danielramosacosta.rustier.domain.RustfmtExecutor
import com.github.danielramosacosta.rustier.infrastructure.DocumentIOIntellij
import com.github.danielramosacosta.rustier.infrastructure.RustfmtExecutorExec
import com.intellij.openapi.editor.Document
import com.intellij.openapi.fileEditor.FileDocumentManagerListener
import com.intellij.openapi.project.ProjectManager

class RustFormatterListener : FileDocumentManagerListener {
    override fun beforeDocumentSaving(document: Document) {
        val project = ProjectManager.getInstance().openProjects.first()
        val intellijDocument: DocumentIO = DocumentIOIntellij(document)
        val rustFmtExecutor: RustfmtExecutor = RustfmtExecutorExec(project)

        RustFormatter(intellijDocument, rustFmtExecutor).invoke()
    }
}
