package com.company.problems.ctci.StacksAndQueues

import com.company.problems.ctci.Utils.Node
import java.lang.NullPointerException

class Queue {

    private var head: Node? = null
    private var tail: Node? = null

    fun add(value: Int) {
        var node = Node(value)
        when (head) {
            null -> {
                head = node
                tail = node
            }
            else -> {
                tail!!.next = node
                tail = node
            }
        }
    }

    fun remove() {
        if (head != null) {
            head = head!!.next
        } else {
            throw EmptyQueueException("Empty Queue")
        }
    }

    fun peek(): Node? {
        return head
    }

    fun isEmpty(): Boolean = head == null

    class EmptyQueueException(s: String) : NullPointerException(s)

    companion object {
        fun displayQueue(head: Node?) {
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