package com.company.problems.ctci.LinkedLists

object Partition {
    fun partition(node: SinglyLinkedList.Node, x: Int): SinglyLinkedList.Node {
        if (node == null) println("Empty List")

        var head = node
        var tail = node
        var current: SinglyLinkedList.Node? = node
        while (current != null) {
            var next = current.next
            when {
                current.value < x -> {
                    current.next = head
                    head = current
                }

                else -> {
                    tail.next = current
                    tail = current
                }
            }

            current = next
        }

        tail.next = null

        return head
    }
}