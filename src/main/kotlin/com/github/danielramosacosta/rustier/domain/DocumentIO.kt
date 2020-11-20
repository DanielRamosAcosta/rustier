package com.github.danielramosacosta.rustier.domain

interface DocumentIO {
    fun readDocument(): String
    fun writeDocument(text: String): Unit
    fun isNotARustFile(): Boolean
}
