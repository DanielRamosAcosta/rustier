package com.github.danielramosacosta.rustier.infrastructure

import com.github.danielramosacosta.rustier.domain.DocumentIO
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.CommandProcessor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.DocumentRunnable

class DocumentIOIntellij(private val document: Document) : DocumentIO {
    override fun readDocument(): String {
        return document.text
    }

    override fun writeDocument(text: String) {
        performUndoableWrite(
                object : DocumentRunnable(
                        document,
                        null
                ) {
                    override fun run() {
                        document.replaceString(0, document.textLength, text)
                    }
                }
        )
    }

    private fun performUndoableWrite(documentRunnable: DocumentRunnable) {
        ApplicationManager.getApplication().runWriteAction {
            CommandProcessor.getInstance().runUndoTransparentAction(documentRunnable)
        }
    }

    override fun isNotARustFile(): Boolean = isARustFile().not()

    private fun isARustFile(): Boolean = document.toString().endsWith(".rs]")

}