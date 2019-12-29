package com.company.problems.ctci.LinkedLists

import com.company.problems.ctci.Utils.Node

object KthToLastElement {
    fun kthToLastElement(k: Int, node: Node): Int {
        if (node == null || k < 0) {
            return -1
        }

        var runner: Node? = node
        var count = 0
        while (runner!!.next != null) {
            runner = runner.next
            count++
        }
        var loc = count - k
        if (k > count) {
            return -1
        } else if (k == count) {
            return node!!.value
        }

        var tracker = 0
        runner = node
        while (tracker != loc) {
            tracker++
            runner = runner!!.next
        }

        return runner!!.value
    }

    fun kthToLastElementIterative(node: Node?, k: Int): Int {
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

    fun kthToLastElementRecursive(node: Node?, k: Int): NodeWrapper {
        if (k < 0){
            NodeWrapper(0, Node(-1))
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

    data class NodeWrapper(var index: Int, var node: Node?)
}