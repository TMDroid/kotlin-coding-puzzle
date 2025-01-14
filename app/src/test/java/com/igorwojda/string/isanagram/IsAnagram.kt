package com.igorwojda.string.isanagram

import org.amshove.kluent.shouldEqual
import org.junit.Test

fun getLetterFrequency(str: String): Map<Char, Int> {
    return mutableMapOf<Char, Int>().apply {
        for (letter in str.toLowerCase()) {
            if(!letter.isLetterOrDigit()) continue

            if (this.keys.contains(letter)) {
                this[letter] = this[letter]!! + 1
            } else {
                this[letter] = 1
            }
        }
    }
}

private fun isAnagram(str1: String, str2: String): Boolean {
    val first = getLetterFrequency(str1)
    val second = getLetterFrequency(str2)

    return first == second
}

class AnagramTest {
    @Test
    fun `"rail safety" is an anagram of "fairy tales"`() {
        isAnagram("rail safety", "fairy tales") shouldEqual true
    }

    @Test
    fun `"RAIL! SAFETY!" is an anagram of "fairy tales" - ignore letter casing`() {
        isAnagram("RAIL SAFETY", "fairy tales") shouldEqual true
    }

    @Test
    fun `"RAIL! SAFETY!" is an anagram of "fairy tales" - ignore special characters`() {
        isAnagram("rail safety!!", "fairy tales") shouldEqual true
    }

    @Test
    fun `"hi" is an anagram of "ihi"`() {
        isAnagram("hi", "ihi") shouldEqual false
    }

    @Test
    fun `"hello" is an anagram of "llohe"`() {
        isAnagram("hello", "llohe") shouldEqual true
    }

    @Test
    fun `"Whoa! Hi!" is an anagram of "Hi! Whoa!"`() {
        isAnagram("Whoa! Hi!", "Hi! Whoa!") shouldEqual true
    }

    @Test
    fun `"One One" is not an anagram of "Two two two"`() {
        isAnagram("One One", "Two two two") shouldEqual false
    }

    @Test
    fun `"One one" is not an anagram of "One one c"`() {
        isAnagram("One one", "One one c") shouldEqual false
    }

    @Test
    fun `"One one" is not an anagram of "One one  " - ignore spaces`() {
        isAnagram("One one", "One one  ") shouldEqual true
    }

    @Test
    fun `"A tree, a life, a bench" is not an anagram of "A tree, a fence, a yard"`() {
        isAnagram("A tree, a life, a bench", "A tree, a fence, a yard") shouldEqual false
    }
}
