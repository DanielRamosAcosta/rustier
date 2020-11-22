package com.github.danielramosacosta.rustier.infrastructure

import com.github.danielramosacosta.rustier.RustfmtStateService
import com.github.danielramosacosta.rustier.domain.RustfmtExecutor
import com.intellij.openapi.project.Project
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.stream.Collectors

class RustfmtExecutorExec(private val project: Project) : RustfmtExecutor {
    override fun format(sourceCode: String): String {
        val rustFmtPath = getRustFmtPath()

        val rustfmt = Runtime.getRuntime().exec("$rustFmtPath --emit stdout")
        val stdin = rustfmt.outputStream
        val stdout = rustfmt.inputStream

        val writer = BufferedWriter(OutputStreamWriter(stdin))

        writer.write(sourceCode)
        writer.flush()
        writer.close()

        val formattedSourceCode = BufferedReader(InputStreamReader(stdout))
            .lines()
            .collect(Collectors.joining("\n"))

        stdout.close()

        return formattedSourceCode
    }

    private fun getRustFmtPath(): String {
        val rustfmtStateService = RustfmtStateService.getInstance(project)
        return rustfmtStateService.getRusfmtPath()
    }
}
