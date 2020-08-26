package com.igorwojda.integer.fizzbuzz

import org.amshove.kluent.shouldEqual
import org.junit.Test

private fun fizzBuzz(n: Int): List<String> {
    return mutableListOf<String>().apply {
        (1..n).forEach {
            add(
                when {
                    it % 3 == 0 && it % 5 == 0 -> "FizzBuzz"
                    it % 3 == 0 -> "Fizz"
                    it % 5 == 0 -> "Buzz"
                    else -> it.toString()
                }
            )
        }
    }
}

class FizzBuzzTest {

    @Test
    fun `Calling fizzbuzz with "5" returns list with 5 items`() {
        fizzBuzz(5) shouldEqual listOf("1", "2", "Fizz", "4", "Buzz")
    }

    @Test
    fun `Calling fizzbuzz with 15 prints out the correct values`() {

        val list = listOf(
            "1", "2", "Fizz", "4", "Buzz", "Fizz",
            "7", "8", "Fizz", "Buzz", "11", "Fizz",
            "13", "14", "FizzBuzz", "16"
        )

        fizzBuzz(16) shouldEqual list
    }
}
