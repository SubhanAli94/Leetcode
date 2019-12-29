package com.company.problems.ctci.StacksAndQueues

import com.company.problems.ctci.LinkedLists.SinglyLinkedList
import com.company.problems.ctci.Utils.Node
import java.lang.NullPointerException

class Stack {

    private var head: Node? = null

    fun push(value: Int) {
        when (head) {
            null -> head = Node(value)
            else -> {
                var temp = head
                head = Node(value)
                head!!.next = temp
            }
        }
    }

    fun pop() {
        head = head?.next
    }

    fun peek(): Node? {
        return head
    }

    fun isEmpty(): Boolean = head == null

    companion object {
        fun displayStack(head: Node?) {
            if (head != null) {
                var n = head
                while (n!!.next != null) {
                    print(" " + n.value + " ")
                    n = n.next
                }
                print(" " + n.value + " ")
            } else {
                throw NullPointerException("Head is set to null. LinkedList is empty")
            }
        }
    }
}