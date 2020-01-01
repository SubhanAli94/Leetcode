package com.company.problems.ctci.StacksAndQueues

import com.company.problems.ctci.Utils.Node
import java.lang.NullPointerException
import kotlin.math.min

class MinNode(var value: Int, var next: MinNode? = null, var min: Int)

class StackWithMin {
    protected var head: MinNode? = null

    open fun push(value: Int) {
        when (head) {
            null -> head = MinNode(value, min = value)
            else -> {
                var temp = head
                var min = min(head!!.min, value)
                head = MinNode(value, temp, min)
            }
        }
    }

    open fun pop() {
        head = head?.next
    }

    fun peek(): MinNode? {
        return head
    }

    fun min(): Int? {
        return head?.min
    }


}