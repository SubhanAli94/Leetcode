package com.company.problems.ctci.LinkedLists

import com.company.problems.ctci.Utils.Node

object Intersection {
    fun intersection(n0: Node, n1: Node): Node? {
        var l0 = SinglyLinkedList.length(n0)
        var l1 = SinglyLinkedList.length(n1)

        var n1lastNode = SinglyLinkedList.nodeAtTail(n0)
        var n2lastNode = SinglyLinkedList.nodeAtTail(n1)

        if (n1lastNode == n2lastNode) {
            var localN0: Node? = n0
            var localN1: Node? = n1
            when {
                l0 > l0 -> localN0 = chopOff(n0, l0 - l1)
                l0 < l1 -> localN1 = chopOff(n1, l1 - l0)
            }

            while (localN0 != localN1) {
                localN0 = localN0?.next
                localN1 = localN1?.next
            }
            return localN0
        } else {
            return null
        }
    }

    private fun chopOff(n: Node, diff: Int): Node {
        var d = diff
        var tempN = n
        while (d != 0) {
            tempN = tempN.next!!
            d--
        }

        return tempN
    }
}