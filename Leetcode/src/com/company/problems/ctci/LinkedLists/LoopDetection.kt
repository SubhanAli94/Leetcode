package com.company.problems.ctci.LinkedLists

import com.company.problems.ctci.Utils.Node

object LoopDetection {
    fun loopDetection(node: Node): Node? {

        var slowRunner: Node? = node
        var fastRunner: Node? = node

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