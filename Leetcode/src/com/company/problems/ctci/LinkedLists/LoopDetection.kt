package com.company.problems.ctci.LinkedLists

object LoopDetection {
    fun loopDetection(node: SinglyLinkedList.Node): SinglyLinkedList.Node? {

        var slowRunner: SinglyLinkedList.Node? = node
        var fastRunner: SinglyLinkedList.Node? = node

        while (slowRunner?.next != null && fastRunner?.next != null) {

            slowRunner = slowRunner.next
            fastRunner = fastRunner.next?.next

            if (slowRunner == fastRunner) {
                break
            }
        }

        if (fastRunner?.next == null){
            return null
        }

        //1 2 3 4 2
        slowRunner = node
        while (slowRunner != fastRunner){
            slowRunner = slowRunner?.next
            fastRunner = fastRunner?.next
        }

        return slowRunner
    }
}