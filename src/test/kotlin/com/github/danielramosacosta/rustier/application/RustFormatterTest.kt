package com.github.danielramosacosta.rustier.application

import org.junit.Test
import kotlin.test.assertEquals

internal class RustFormatterTest {
    @Test
    fun `execute the works`() {
        val sourceCode = """fn main  (  ){println!("Hello world!");     }"""
        val formattedSourceCode = """
            fn main() {
                println!("Hello world!");
            }
        """.trimIndent()


        val intellijDocument = DocumentIOFake(sourceCode, true)
        val rustfmtExecutor = RustfmtExecutorFake()

        val rustFormatter = RustFormatter(intellijDocument, rustfmtExecutor)

        rustFormatter.invoke()

        assertEquals(formattedSourceCode, intellijDocument.getLastWriteEntry())
    }
}