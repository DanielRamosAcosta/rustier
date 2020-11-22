package com.github.danielramosacosta.rustier.actions

import com.github.danielramosacosta.rustier.application.RustFormatter
import com.github.danielramosacosta.rustier.domain.DocumentIO
import com.github.danielramosacosta.rustier.domain.RustfmtExecutor
import com.github.danielramosacosta.rustier.infrastructure.DocumentIOIntellij
import com.github.danielramosacosta.rustier.infrastructure.RustfmtExecutorExec
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys

class ReformatWithRustfmtAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        println("Action Performed")

        e.project?.let { project ->
            val editor = e.getData(CommonDataKeys.EDITOR)

            editor?.let {
                val intellijDocument: DocumentIO = DocumentIOIntellij(editor.document)
                val rustFmtExecutor: RustfmtExecutor = RustfmtExecutorExec(project)

                RustFormatter(intellijDocument, rustFmtExecutor).invoke()
            }
        }
    }
}
