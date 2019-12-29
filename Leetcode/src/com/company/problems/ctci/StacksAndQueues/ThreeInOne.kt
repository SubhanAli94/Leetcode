package com.company.problems.ctci.StacksAndQueues

import java.lang.Exception

object ThreeInOne {
    private lateinit var sizes: IntArray
    private lateinit var values: IntArray
    private var stackCapacity: Int = 0

    fun init(stackCapacity: Int, numOfStacks: Int) {

        this.stackCapacity = stackCapacity
        sizes = IntArray(numOfStacks)
        values = IntArray(numOfStacks * stackCapacity)
    }

    fun push(value: Int, stackNum: Int) {
        if (sizes[stackNum] == stackCapacity) {
            throw StackFullException()
            return
        }
        sizes[stackNum]++
        var offset = stackNum * stackCapacity + sizes[stackNum] - 1
        values[offset] = value
    }

    fun pop(stackNum: Int) {
        if (sizes[stackNum] == 0) throw EmptyStackException()

        var offset = stackNum * stackCapacity + sizes[stackNum] - 1
        sizes[stackNum]--
        values[offset] = 0
    }

    fun peek(stackNum: Int): Int {
        var offset = stackNum * stackCapacity + sizes[stackNum] - 1
        return values[offset]
    }

    fun printStacksArray() {
        for (e in values) print(" $e ")
    }

    class StackFullException(message: String = "Stack is full. Push is not allowed.") : Exception(message)
    class EmptyStackException(message: String = "Stack is empty") : Exception(message)
}