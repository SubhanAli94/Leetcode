package com.company.problems.ctci.LinkedLists

import java.lang.Exception
import java.lang.NullPointerException

object SinglyLinkedList {

    class Node(value: Int) {
        var value: Int = value
        var next: Node? = null
    }

    var head: Node? = null

    fun appendToTail(value: Int) {
        if (head == null) {
            head = Node(value)
        } else {
            var node: Node = head!!
            while (node.next != null) {
                node = node.next!!
            }
            node.next = Node(value)
        }
    }

    fun deleteAtTail() {
        if (head != null) {

            if (head!!.next == null) {
                head = null
            } else {
                var n = head
                while (n!!.next!!.next != null) {
                    n = n.next
                }
                n.next = null
            }
        } else {
            throw EmptyListException()
        }
    }

    fun addAtStart(n: Int, head: Node? = null): Node {
        var tempHead = head
        if (tempHead == null) {
            tempHead = Node(n)
        } else {
            var temp = tempHead
            tempHead = Node(n)
            tempHead!!.next = temp
        }

        this.head = tempHead
        return tempHead
    }

    fun deleteNode(n: Node) {
        if (head != null) {
            when {
                head!!.value == n.value -> {
                    head = head!!.next
                }
                head!!.next == null -> {
                    throw NodeNotFoundException()
                }
                else -> {
                    var prev = head
                    var curr = head
                    while (curr != null) {

                        if (curr.value == n.value) {
                            prev!!.next = curr.next
                            break
                        }
                        prev = curr
                        curr = curr.next
                    }
                }
            }
        } else {
            throw EmptyListException()
        }
    }

    fun deleteFromStart() {
        if (head != null) {
            head = head!!.next
        }
    }

    fun displayLinkedList(head: Node?) {
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

    class EmptyListException : Exception("Linked List is empty")
    class NodeNotFoundException : Exception("Node not found")
}