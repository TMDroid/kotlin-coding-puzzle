package com.igorwojda.integer.reverse

import org.amshove.kluent.shouldEqual
import org.junit.Test
import kotlin.math.absoluteValue
import kotlin.math.sign

private fun reverseInt(i: Int): Int {
    return i.absoluteValue
        .toString()
        .reversed()
        .toInt() * i.sign
}

class ReverseIntTest {
    @Test
    fun `ReverseInt handles 0 as an input`() {
        reverseInt(0) shouldEqual 0
    }

    @Test
    fun `ReverseInt flips a positive number`() {
        reverseInt(5) shouldEqual 5
        reverseInt(15) shouldEqual 51
        reverseInt(90) shouldEqual 9
        reverseInt(700) shouldEqual 7
        reverseInt(2359) shouldEqual 9532
    }

    @Test
    fun `ReverseInt flips a negative number`() {
        reverseInt(-5) shouldEqual -5
        reverseInt(-15) shouldEqual -51
        reverseInt(-90) shouldEqual -9
        reverseInt(-700) shouldEqual -7
        reverseInt(-2359) shouldEqual -9532
    }
}
