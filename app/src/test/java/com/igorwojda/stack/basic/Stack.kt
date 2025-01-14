package com.igorwojda.stack.basic

import org.amshove.kluent.shouldEqual
import org.junit.Test
import java.util.*

private class Stack<E> {
    val list: MutableList<E> = LinkedList<E>()
    val size
        get() = list.size

    fun add(element: E) {
        list.add(element)
    }

    fun remove(): E? {
        return if(size > 0) {
            list.removeAt(list.lastIndex)
        } else null
    }

    fun peek(): E? {
        return if(size > 0) {
            list[list.lastIndex]
        } else null
    }

    fun isEmpty(): Boolean {
        return list.isEmpty()
    }
}

class StackTest {
    @Test
    fun `stack can add and remove items`() {
        Stack<Int>().apply {
            add(1)
            remove() shouldEqual 1
            add(2)
            remove() shouldEqual 2
        }
    }

    @Test
    fun `stack can follows first in, last out`() {
        Stack<Int>().apply {
            add(1)
            add(2)
            add(3)
            remove() shouldEqual 3
            remove() shouldEqual 2
            remove() shouldEqual 1
        }
    }

    @Test
    fun `peek returns the first element but does not remove it`() {
        Stack<Char>().apply {
            add('A')
            add('B')
            add('C')
            peek() shouldEqual 'C'
            remove() shouldEqual 'C'
            peek() shouldEqual 'B'
            remove() shouldEqual 'B'
            peek() shouldEqual 'A'
            remove() shouldEqual 'A'
            peek() shouldEqual null
            remove() shouldEqual null
        }
    }

    @Test
    fun `newly created stack is empty`() {
        Stack<Char>().apply {
            isEmpty() shouldEqual true
        }
    }

    @Test
    fun `stack is empty after removing all items`() {
        Stack<Char>().apply {
            add('A')
            add('B')
            add('C')
            peek()
            remove()
            peek()
            remove()
            peek()
            remove()

            isEmpty() shouldEqual true
        }
    }

    @Test
    fun `stack with items is not empty`() {
        Stack<Char>().apply {
            add('A')
            isEmpty() shouldEqual false
            add('B')
            isEmpty() shouldEqual false
            add('C')
            isEmpty() shouldEqual false
        }
    }

    @Test
    fun `stack has correct size`() {
        Stack<Char>().apply {
            size shouldEqual 0

            add('A')
            size shouldEqual 1

            add('B')
            size shouldEqual 2

            add('C')
            size shouldEqual 3

            remove()
            size shouldEqual 2

            remove()
            size shouldEqual 1

            remove()
            size shouldEqual 0
        }
    }
}
