package com.github.danielramosacosta.rustier.application

import com.intellij.testFramework.LightPlatformCodeInsightTestCase
import com.intellij.testFramework.LightPlatformCodeInsightTestCase.createAndSaveFile
import com.intellij.testFramework.LightPlatformCodeInsightTestCase.type
import com.intellij.testFramework.PlatformTestUtil
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import org.junit.Test
import kotlin.test.assertEquals

internal class RustFormatterTest: BasePlatformTestCase {
    constructor(){}

    override fun setUp() {
        super.setUp()
    }
    @Test
    fun `format on save`() {
        println("Here")
    }

}
