package com.company.problems.ctci.LinkedLists

object Partition {
    fun partition(node: SinglyLinkedList.Node, x: Int): SinglyLinkedList.Node {
        if (node == null) println("Empty List")

        var current: SinglyLinkedList.Node? = node
        var rightMarkerHead: SinglyLinkedList.Node? = null
        var rightMarker: SinglyLinkedList.Node? = null
        var leftMarkerHead: SinglyLinkedList.Node? = null
        var leftMarker: SinglyLinkedList.Node? = null
        while (current != null) {

            if (current.value < x) {
                if (leftMarker == null) {
                    leftMarkerHead = current
                    leftMarker = leftMarkerHead
                } else {
                    leftMarker.next = current
                    leftMarker = leftMarker.next
                }
            } else {
                if (rightMarker == null) {
                    rightMarkerHead = current
                    rightMarker = rightMarkerHead
                } else {
                    rightMarker.next = current
                    rightMarker = rightMarker.next
                }
            }
            current = current.next
        }

        if (leftMarkerHead == null) {
            return rightMarkerHead!!
        }
        leftMarker!!.next = rightMarkerHead

        return leftMarkerHead
    }
}