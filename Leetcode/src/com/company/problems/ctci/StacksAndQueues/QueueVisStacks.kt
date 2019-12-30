package com.company.problems.ctci.StacksAndQueues

class QueueVisStacks {

    var resultStack = Stack()
    var tempStack = Stack()

    fun enqueue(value: Int) {
        resultStack.push(value)
    }

    fun dequeue() {
        if (tempStack.isEmpty()) {
            while (!resultStack.isEmpty()) {
                tempStack.push(resultStack.peek()!!.value)
                resultStack.pop()
            }
        } else {
            tempStack.pop()
        }
    }

    fun peek(): Int? {
        if (tempStack.isEmpty()) {
            while (!resultStack.isEmpty()) {
                tempStack.push(resultStack.peek()!!.value)
                resultStack.pop()
            }
        }

        return tempStack.peek()?.value
    }

    fun isEmpty() {
        resultStack.isEmpty()
    }
}