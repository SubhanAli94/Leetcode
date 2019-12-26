package com.company.problems.ctci.LinkedLists

import java.util.*

object Palindrome {
    fun palindromeReverseAndCompare(node: SinglyLinkedList.Node): Boolean {

        if (node.next == null) return true
        var reversedNode = reverseAndClone(node)
        var tempNode: SinglyLinkedList.Node? = node

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

    private fun reverseAndClone(node: SinglyLinkedList.Node): SinglyLinkedList.Node? {
        var tempNode: SinglyLinkedList.Node? = node
        var result: SinglyLinkedList.Node? = null

        while (tempNode != null) {
            var newNode = SinglyLinkedList.Node(tempNode.value)
            newNode.next = result
            result = newNode

            tempNode = tempNode.next
        }
        return result
    }

    fun palindromeIterative(node: SinglyLinkedList.Node): Boolean {

        if (node.next == null) return true
        if (node.next?.next == null) return node.value == node.next?.value

        var fastRunner: SinglyLinkedList.Node? = node
        var slowRunner: SinglyLinkedList.Node? = node

        var stack = Stack<SinglyLinkedList.Node>()

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

    fun palindromeRecursive(node: SinglyLinkedList.Node, length: Int): Boolean {
        when (length) {
            0 -> return false
            1 -> return true
        }

        return palindromeRecurseCall(node, length).result
    }


    //1 2 1
    //1 1
    data class Result(var node: SinglyLinkedList.Node?, var result: Boolean)

    private fun palindromeRecurseCall(node: SinglyLinkedList.Node?, length: Int): Result {
        when {
            node == null || length == 0 -> return Result(node, true)
            length == 1 -> return Result(node.next, true)
        }

        var res = palindromeRecurseCall(node!!.next!!, length - 2)

        if (!res.result) return res

        return Result(res.node!!.next, res.node!!.value == node.value)
    }
}