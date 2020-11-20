package com.github.danielramosacosta.rustier.application

import com.github.danielramosacosta.rustier.domain.DocumentIO

internal class DocumentIOFake(private val sourceCode: String, private val isRustFile: Boolean): DocumentIO {

    private var lastWriteEntry = "Nothing writted"

    override fun readDocument(): String = sourceCode

    override fun writeDocument(text: String) { lastWriteEntry = text }

    override fun isNotARustFile(): Boolean = isRustFile.not()

    fun getLastWriteEntry(): String = lastWriteEntry
}