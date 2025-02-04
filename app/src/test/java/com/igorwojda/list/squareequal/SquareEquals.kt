package com.igorwojda.list.squareequal

import org.amshove.kluent.shouldEqual
import org.junit.Test

private fun squareEquals(list: List<Int>, squared: List<Int>): Boolean {
    return list.groupBy { it }.all {
        val square = it.key * it.key
        squared.contains(square) && squared.filter { it == square }.size == it.value.size
    }
}

class SquareEqualsTest {
    @Test
    fun `square 2 equal square 4`() {
        squareEquals(listOf(2), listOf(4)) shouldEqual true
    }

    @Test
    fun `square 1, 2, 3 equals square 9, 1, 4`() {
        squareEquals(listOf(1, 2, 3), listOf(9, 1, 4)) shouldEqual true
    }

    @Test
    fun `square 1, 2, 3 does not equal square 9, 1, 7`() {
        squareEquals(listOf(1, 2, 3), listOf(9, 1, 7)) shouldEqual false
    }

    @Test
    fun `square 1, 2, 3 does not equal square 9, 1`() {
        squareEquals(listOf(1, 2, 3), listOf(9, 1)) shouldEqual false
    }

    @Test
    fun `square 1, 2, 1 does not equal 4, 1, 4`() {
        squareEquals(listOf(1, 2, 1), listOf(4, 1, 4)) shouldEqual false
    }
}
