package com.company.problems.ctci.LinkedLists

import com.company.problems.ctci.Utils.Node
import java.util.*

object Palindrome {
    fun palindromeReverseAndCompare(node: Node): Boolean {

        if (node.next == null) return true
        var reversedNode = reverseAndClone(node)
        var tempNode: Node? = node

        while (reversedNode != null && tempNode != null) {
            when {
                reversedNode.value != tempNode.value -> return false
                else -> {
                    reversedNode = reversedNode.next
                    tempNode = tempNode.next
                }
            }
        }


        return tempNode == null && reversedNode == null
    }

    private fun reverseAndClone(node: Node): Node? {
        var tempNode: Node? = node
        var result: Node? = null

        while (tempNode != null) {
            var newNode = Node(tempNode.value)
            newNode.next = result
            result = newNode

            tempNode = tempNode.next
        }
        return result
    }

    fun palindromeIterative(node: Node): Boolean {

        if (node.next == null) return true
        if (node.next?.next == null) return node.value == node.next?.value

        var fastRunner: Node? = node
        var slowRunner: Node? = node

        var stack = Stack<Node>()

        while (fastRunner?.next != null) {

            fastRunner = fastRunner.next?.next

            stack.push(slowRunner)
            slowRunner = slowRunner?.next
        }

        if (fastRunner != null) slowRunner = slowRunner?.next
        while (slowRunner != null) {
            var poppedNode = stack.pop()
            if (slowRunner.value != poppedNode.value) {
                return false
            }
            slowRunner = slowRunner.next
        }


        return true
    }

    fun palindromeRecursive(node: Node, length: Int): Boolean {
        when (length) {
            0 -> return false
            1 -> return true
        }

        return palindromeRecurseCall(node, length).result
    }


    //1 2 1
    //1 1
    data class Result(var node: Node?, var result: Boolean)

    private fun palindromeRecurseCall(node: Node?, length: Int): Result {
        when {
            node == null || length == 0 -> return Result(node, true)
            length == 1 -> return Result(node.next, true)
        }

        var res = palindromeRecurseCall(node!!.next!!, length - 2)

        if (!res.result) return res

        return Result(res.node!!.next, res.node!!.value == node.value)
    }
}