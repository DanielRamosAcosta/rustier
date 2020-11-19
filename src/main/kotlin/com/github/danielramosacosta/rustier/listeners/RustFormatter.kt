package com.github.danielramosacosta.rustier.listeners

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.CommandProcessor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.DocumentRunnable
import com.intellij.openapi.fileEditor.FileDocumentManagerListener
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.Scanner

class RustFormatter : FileDocumentManagerListener {
    override fun beforeDocumentSaving(document: Document) {
        if (!document.toString().contains(".rs")) {
            return super.beforeDocumentSaving(document)
        }

        val data = document.text

        performUndoableWrite(object : DocumentRunnable(document, null) {
            override fun run() {
                val rustfmt = Runtime.getRuntime().exec("rustfmt --emit stdout")

                val stdin = rustfmt.outputStream
                val stdout = rustfmt.inputStream

                val writer = BufferedWriter(OutputStreamWriter(stdin))

                writer.write(data)
                writer.flush()
                writer.close()

                val scanner = Scanner(stdout)
                val stringBuilder = StringBuilder()
                while (scanner.hasNextLine()) {
                    val message = scanner.nextLine()
                    stringBuilder.append(message + "\n")
                }

                val final = stringBuilder.toString()

                if (final.isNotBlank()) {
                    document.replaceString(0, data.length, final)
                }
            }
        })
    }

    private fun performUndoableWrite(documentRunnable: DocumentRunnable) {
        ApplicationManager.getApplication().runWriteAction {
            CommandProcessor.getInstance().runUndoTransparentAction(documentRunnable)
        }
    }
}
