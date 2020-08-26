package com.igorwojda.integer.pyramidgenerator

import org.amshove.kluent.shouldEqual
import org.junit.Test

fun generatePyramid(n: Int): List<String> {
    return mutableListOf<String>().apply {
        for(i in 0 until n) {
            val row = " ".repeat(n - i - 1) + "#".repeat(2 * i + 1) + " ".repeat(n - i - 1)
            this.add(row)
        }
    }
}

class PyramidGeneratorTest {

    @Test
    fun `pyramid n = 2`() {
        generatePyramid(2).also {
            it.size shouldEqual 2
            it[0] shouldEqual " # "
            it[1] shouldEqual "###"
        }
    }

    @Test
    fun `pyramid n = 3`() {
        generatePyramid(3).also {
            it.size shouldEqual 3
            it[0] shouldEqual "  #  "
            it[1] shouldEqual " ### "
            it[2] shouldEqual "#####"
        }
    }

    @Test
    fun `pyramid n = 4`() {
        generatePyramid(4).also {
            it.size shouldEqual 4
            it[0] shouldEqual "   #   "
            it[1] shouldEqual "  ###  "
            it[2] shouldEqual " ##### "
            it[3] shouldEqual "#######"
        }
    }
}
