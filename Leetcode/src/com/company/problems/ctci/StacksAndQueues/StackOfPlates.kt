package com.company.problems.ctci.StacksAndQueues

import java.lang.Exception

class StackOfPlates(var capacity: Int) {
    private var stacks = arrayListOf<PlatesStack>()

    fun push(value: Int) {
        if (stacks.size == 0 || stacks[stacks.size - 1].size == capacity) {
            var stack = PlatesStack()
            stack.push(value)

            stacks.add(stack)

        } else {
            var stack = stacks[stacks.size - 1]
            stack.push(value)
        }
    }

    fun pop() {
        if (stacks.size != 0) {
            var stack = stacks[stacks.size - 1]
            stack.pop()

            if (stacks[stacks.size - 1].isEmpty()) {
                stacks.removeAt(stacks.size - 1)
            }
        }
    }

    fun peek(): Int {
        if (stacks != null) {
            return stacks[stacks.size - 1].peek()
        }
        throw EmptyStackException()
    }

    fun popAtIndex(index: Int) {
        if (stacks.size > 0 && stacks.size > index) {
            stacks[index].pop()

            if (stacks[index].isEmpty()) {
                stacks.removeAt(index)
                return
            }
        }

        if (stacks.size - 1 > index) {
            //shift required
            shiftLeft(index + 1)
        }
    }


    // 0 1 2 3
    fun shiftLeft(index: Int) {
        var bottom = stacks[index].endNode
        stacks[index - 1].push(bottom!!.value)
        stacks[index].endNode = bottom.above

        if (stacks[index].endNode == null) {
            stacks.removeAt(index)
            return
        }

        stacks[index].endNode!!.below = null

        stacks[index].size--

        if (stacks.size > index + 1) {
            shiftLeft(index + 1)
        }
    }

    class EmptyStackException(message: String = "Empty Stack") : Exception(message)
}