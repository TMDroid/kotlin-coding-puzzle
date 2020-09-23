package com.igorwojda.string.hasrepeatedcharacter

import org.amshove.kluent.shouldEqual
import org.junit.Test

private fun hasRepeatedChar(str: String): Boolean {
    val chars = HashSet<Char>()

    str.forEach {
        if(chars.contains(it)) return true
        chars.add(it)
    }

    return false
}

class RepeatedCharacterTest {
    @Test
    fun `"abc" don't have repeated character`() {
        hasRepeatedChar("abc") shouldEqual false
    }

    @Test
    fun `"aabc" has repeated character`() {
        hasRepeatedChar("aabc") shouldEqual true
    }

    @Test
    fun `"aabcc" has repeated character`() {
        hasRepeatedChar("aabcc") shouldEqual true
    }
}
