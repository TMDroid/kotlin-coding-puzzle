package com.igorwojda.string.vowels

import org.amshove.kluent.shouldEqual
import org.junit.Test

private fun vowels(str: String): Int {
    val vowels = "aeiouy"

    return str.toLowerCase().fold(0) { acc: Int, c: Char ->
        acc + (if(vowels.contains(c)) 1 else 0)
    }
}

class VowelsTest {
    @Test
    fun `"aeiouy" has 6 vovels`() {
        vowels("aeiouy") shouldEqual 6
    }

    @Test
    fun `"AEIOUY" has 6 vovels`() {
        vowels("AEIOUY") shouldEqual 6
    }

    @Test
    fun `"abcdefghijklmnopqrstuvwxyz" has 6 vovels`() {
        vowels("abcdefghijklmnopqrstuvwxyz") shouldEqual 6
    }

    @Test
    fun `"bcadfaghijkl" has 3 vovels`() {
        vowels("bcadfaghijkl") shouldEqual 3
    }

    @Test
    fun `"bcdfghjkl" has 0 vovels`() {
        vowels("bcdfghjkl") shouldEqual 0
    }
}
