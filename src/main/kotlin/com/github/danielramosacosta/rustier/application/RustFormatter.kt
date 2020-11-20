package com.github.danielramosacosta.rustier.application

import com.github.danielramosacosta.rustier.domain.DocumentIO
import com.github.danielramosacosta.rustier.domain.RustfmtExecutor

class RustFormatter(
        private val document: DocumentIO,
        private val rustfmtExecutor: RustfmtExecutor,
) {
    fun invoke(): FormatResult {
        if (document.isNotARustFile()) {
            return FormatResult.FILE_UNCHANGED
        }

        val sourceCode = document.readDocument()
        val formattedSourceCode = rustfmtExecutor.format(sourceCode)

        if (formattedSourceCode.isNotBlank()) {
            document.writeDocument(formattedSourceCode)
        }

        return FormatResult.FILE_CHANGED
    }
}