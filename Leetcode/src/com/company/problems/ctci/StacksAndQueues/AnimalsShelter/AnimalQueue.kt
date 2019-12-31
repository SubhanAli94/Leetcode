package com.company.problems.ctci.StacksAndQueues.AnimalsShelter

import com.company.problems.ctci.Utils.Node
import java.lang.NullPointerException

class AnimalNode(var animal: Animal, var age: Int) {
    var next: AnimalNode? = null
}

class AnimalQueue {
    private var head: AnimalNode? = null
    private var tail: AnimalNode? = null
    private var age: Int = 0

    fun add(animal: Animal, age: Int) {
        var node = AnimalNode(animal, age)
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

    fun peek(): AnimalNode? {
        return head
    }

    fun isEmpty(): Boolean = head == null

    class EmptyQueueException(s: String) : NullPointerException(s)

    companion object {
        fun displayQueue(head: AnimalNode?) {
            if (head != null) {
                var n = head
                while (n!!.next != null) {
                    print(" " + n.animal.name + " ")
                    n = n.next
                }
                print(" " + n.animal.name + " ")
            } else {
                throw NullPointerException("Head is set to null. LinkedList is empty")
            }
        }
    }
}