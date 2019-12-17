package com.company.problems.ctci.LinkedLists

object DeleteMiddleNode {
    fun deleteMiddleNode(node: SinglyLinkedList.Node): Boolean {
        if (node == null || node.next == null) return false

        var tempNode = node
        tempNode.value = node.next!!.value
        tempNode.next = node.next!!.next

        return true
    }
}