package com.igorwojda.list.pairaverage

import org.amshove.kluent.shouldEqual
import org.junit.Test

fun hasAverage(list: List<Int>, average: Double): Boolean {
    list.forEachIndexed { i, a ->
        list.forEachIndexed { j, b ->
            if(i != j) {
                if((a + b).toDouble() == average * 2) {
                    return true
                }
            }
        }
    }

    return false
}

private fun <E> MutableList<E>.aaa2(a: E) {
    set(0, a)
}

fun MutableList<Int>.aaa() {
    set(0, 12)
}

inline fun <K, V> MutableMap<K, V>.incrementExisting(key: K, value: V) {
    put(key, value)
}

class TargetAverageTest {
    @Test
    fun `empty list return false`() {
        hasAverage(listOf(), 1.0) shouldEqual false
    }

    @Test
    fun `list size 1 return false`() {
        hasAverage(listOf(1), 1.0) shouldEqual false
    }

    @Test
    fun `list 3, 5 should with average 5,5 return true`() {
        hasAverage(listOf(3, 5), 5.5) shouldEqual false
    }

    @Test
    fun `list 3, 4, 7, 9 should with average 6,5 return true`() {
        hasAverage(listOf(3, 4, 7, 9), 6.5) shouldEqual true
    }

    @Test
    fun `list 3, 5 should with average 2,7 return true`() {
        hasAverage(listOf(3, 5), 2.7) shouldEqual false
    }

    @Test
    fun `list 3, 5, 9, 7, 11, 14 should with average 8,0 return true`() {
        hasAverage(listOf(3, 5, 9, 7, 11, 14), 8.0) shouldEqual true
    }

    @Test
    fun `list 3, 7, 5 should with average 3,5 return true`() {
        hasAverage(listOf(3, 5, 7), 3.5) shouldEqual false
    }
}
