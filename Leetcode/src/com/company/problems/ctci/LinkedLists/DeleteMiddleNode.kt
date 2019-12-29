package com.company.problems.ctci.LinkedLists

import com.company.problems.ctci.Utils.Node

object DeleteMiddleNode {
    fun deleteMiddleNode(node: Node): Boolean {
        if (node.next == null) return false

        var tempNode = node
        tempNode.value = node.next!!.value
        tempNode.next = node.next!!.next

        return true
    }
}