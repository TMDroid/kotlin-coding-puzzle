package com.igorwojda.string.ispalindrome.tolerant

import org.amshove.kluent.shouldEqual
import org.junit.Test

private fun isTolerantPalindrome(str: String, characterRemoved: Boolean = false): Boolean {
    val half = str.length / 2
    for (i in 0 until half) {
        if(str[i] != str[str.length - i - 1]) {
            if(characterRemoved) {
                return false
            }

            val new = str.replace(str[i].toString(), "")
            return isTolerantPalindrome(new, true)
        }
    }

    return true
}

class IsTolerantPalindromeTest {
    @Test
    fun `"aba" is a palindrome`() {
        isTolerantPalindrome("aba") shouldEqual true
    }

    @Test
    fun `"ab!a" is a palindrome`() {
        isTolerantPalindrome("ab!a") shouldEqual true
    }

    @Test
    fun `"a!ba" is a palindrome`() {
        isTolerantPalindrome("a!ba") shouldEqual true
    }

    @Test
    fun `" aba" is a palindrome`() {
        isTolerantPalindrome(" aba") shouldEqual true
    }

    @Test
    fun `"aa#!aa " is not a palindrome`() {
        isTolerantPalindrome("aa#!aa ") shouldEqual false
    }

    @Test
    fun `"greetings" is not a palindrome`() {
        isTolerantPalindrome("greetings") shouldEqual false
    }

    @Test
    fun `"1000000001" a palindrome`() {
        isTolerantPalindrome("1000000001") shouldEqual true
    }

    @Test
    fun `"10A00000001" is a palindrome`() {
        isTolerantPalindrome("10A00000001") shouldEqual true
    }

    @Test
    fun `"Fish hsif" is not a palindrome`() {
        isTolerantPalindrome("Fish hsif") shouldEqual false
    }

    @Test
    fun `"pennep" a palindrome`() {
        isTolerantPalindrome("pennep") shouldEqual true
    }
}
