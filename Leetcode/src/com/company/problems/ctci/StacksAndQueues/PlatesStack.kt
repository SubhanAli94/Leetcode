package com.company.problems.ctci.StacksAndQueues

import com.company.problems.ctci.Utils.DoublyNode
import com.company.problems.ctci.Utils.Node
import java.lang.Exception

class PlatesStack {
    var endNode: DoublyNode? = null
    var headNode: DoublyNode? = null
    var size: Int = 0

    // 1 -> 2-> 3
    fun push(value: Int) {
        if (headNode == null) {
            headNode = DoublyNode(value)
            endNode = headNode
        } else {
            var node = DoublyNode(value)
            headNode!!.above = node
            node.below = headNode
            headNode = node
        }
        size++
    }

    fun pop() {
        if (headNode != null) {
            headNode = headNode?.below
            size--
        }
    }

    fun peek(): Int {
        if (headNode != null) {
            return headNode!!.value
        }

        throw Exception("Empty Stack")
    }

    fun isEmpty(): Boolean {
        return headNode == null
    }
}