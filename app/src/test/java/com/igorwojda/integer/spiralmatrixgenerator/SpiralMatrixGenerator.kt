package com.igorwojda.integer.spiralmatrixgenerator

import org.amshove.kluent.shouldEqual
import org.junit.Test

enum class Direction {
    DIRECTION_RIGHT, DIRECTION_DOWN, DIRECTION_LEFT, DIRECTION_UP
}

private fun generateSpiralMatrix(n: Int): List<MutableList<Int?>> {
    val total = n * n
    var counter = 1

    var i = 0
    var j = 0

    val matrix = Array(n) { Array(n) { -1 } }
    var direction = Direction.DIRECTION_RIGHT

    while (counter <= total) {
        matrix[i][j] = counter++

        when (direction) {

            Direction.DIRECTION_RIGHT -> if (j == n - 1 || matrix[i][j + 1] != -1) {
                direction = Direction.DIRECTION_DOWN
                i++
            } else j++
            Direction.DIRECTION_DOWN -> if (i == n - 1 || matrix[i + 1][j] != -1) {
                direction = Direction.DIRECTION_LEFT
                j--
            } else i++
            Direction.DIRECTION_LEFT -> if (j == 0 || matrix[i][j - 1] != -1) {
                direction = Direction.DIRECTION_UP
                i--
            } else j--
            Direction.DIRECTION_UP -> if (i == 0 || matrix[i - 1][j] != -1) {
                direction = Direction.DIRECTION_RIGHT
                j++
            } else i--
        }
    }

    return matrix.toList().map { it.toMutableList() }
}

class SpiralMatrixGeneratorTest {
    @Test
    fun `generateSpiralMatrix generates a 2x2 matrix`() {
        val matrix = generateSpiralMatrix(2)
        matrix.size shouldEqual 2
        matrix[0] shouldEqual listOf(1, 2)
        matrix[1] shouldEqual listOf(4, 3)
    }

    @Test
    fun `generateSpiralMatrix generates a 3x3 matrix`() {
        val matrix = generateSpiralMatrix(3)
        matrix.size shouldEqual 3
        matrix[0] shouldEqual listOf(1, 2, 3)
        matrix[1] shouldEqual listOf(8, 9, 4)
        matrix[2] shouldEqual listOf(7, 6, 5)
    }

    @Test
    fun `generateSpiralMatrix generates a 4x4 matrix`() {
        val matrix = generateSpiralMatrix(4)
        matrix.size shouldEqual 4
        matrix[0] shouldEqual listOf(1, 2, 3, 4)
        matrix[1] shouldEqual listOf(12, 13, 14, 5)
        matrix[2] shouldEqual listOf(11, 16, 15, 6)
        matrix[3] shouldEqual listOf(10, 9, 8, 7)
    }
}
