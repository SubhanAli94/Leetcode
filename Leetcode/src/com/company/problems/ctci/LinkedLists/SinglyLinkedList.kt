package com.company.problems.ctci.LinkedLists

import java.lang.Exception
import java.lang.NullPointerException

object SinglyLinkedList {

    class Node(value: Int) {
        var value: Int = value
        var next: Node? = null
    }

    var head: Node? = null

    fun addValueToTail(value: Int): Node {
        var n = Node(value)
        if (head == null) {
            head = n
        } else {
            var node: Node = head!!
            while (node.next != null) {
                node = node.next!!
            }
            node.next = n
        }

        return n
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

    fun nodeAtTail(node: Node): Node {
        var n: Node? = node
        while (n!!.next != null) {
            n = n.next
        }
        return n
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

    fun addNodeAtTail(node: Node, head: Node) {
        var n = head
        while (n.next != null) {
            n = n.next!!
        }
        n.next = node
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

    fun length(node: Node): Int {
        // 1 1 1
        var count = 0
        var n: Node? = node

        while (n != null) {
            n = n.next
            count++
        }
        return count
    }

    class EmptyListException : Exception("Linked List is empty")
    class NodeNotFoundException : Exception("Node not found")
}