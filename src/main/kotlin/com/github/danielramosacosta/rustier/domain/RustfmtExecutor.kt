package com.github.danielramosacosta.rustier.domain

interface RustfmtExecutor {
    fun format(input: String): String
}
