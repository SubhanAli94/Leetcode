package com.company.problems.ctci.LinkedLists

object KthToLastElement {
    fun kthToLastElement(k: Int): Int {
        if (SinglyLinkedList.head == null || k < 0) {
            return -1
        }

        var runner = SinglyLinkedList.head
        var count = 0
        while (runner!!.next != null) {
            runner = runner.next
            count++
        }
        var loc = count - k
        if (k > count) {
            return -1
        } else if (k == count) {
            return SinglyLinkedList.head!!.value
        }

        var tracker = 0
        runner = SinglyLinkedList.head
        while (tracker != loc) {
            tracker++
            runner = runner!!.next
        }

        return runner!!.value
    }

    fun kthToLastElementIterative(node: SinglyLinkedList.Node?, k: Int): Int {
        if (node == null || k < 0) {
            return -1
        }

        var current = node
        var runner = node
        var index = 0
        while (current!!.next != null) {

            if (index >= k) {
                runner = runner!!.next
            }
            index++
            current = current.next
        }

        return if (index < k)
            -1
        else
            runner!!.value
    }

    fun kthToLastElementRecursive(node: SinglyLinkedList.Node?, k: Int): NodeWrapper {
        if (k < 0){
            NodeWrapper(0, SinglyLinkedList.Node(-1))
        }
        if (node == null) {
            return NodeWrapper(0, node)
        }
        var nodeWrapper = kthToLastElementRecursive(node!!.next, k)

        if (nodeWrapper.index == k) {
            nodeWrapper.node = node
        }

        nodeWrapper.index += 1

        return nodeWrapper
    }

    data class NodeWrapper(var index: Int, var node: SinglyLinkedList.Node?)
}