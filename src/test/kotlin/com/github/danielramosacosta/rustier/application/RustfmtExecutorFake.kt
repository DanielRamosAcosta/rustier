package com.github.danielramosacosta.rustier.application

import com.github.danielramosacosta.rustier.domain.RustfmtExecutor

internal class RustfmtExecutorFake : RustfmtExecutor {
    private var formattedSourceCode: String

    constructor(formattedSourceCode: String? = null) {
        if (!formattedSourceCode.isNullOrEmpty()) {
            this.formattedSourceCode = formattedSourceCode
        } else {
            this.formattedSourceCode =
                """
                fn main() {
                    println!("Hello world!");
                }
                """.trimIndent()
        }
    }

    override fun format(input: String): String {
        return this.formattedSourceCode
    }
}
