package com.company.problems.ctci.StacksAndQueues

class SortStack {
    fun sortStack(stack: Stack): Stack {
        var resultStack = Stack()

        while (!stack.isEmpty()) {

            if (resultStack.isEmpty()) {
                resultStack.push(stack.peek()!!.value)
                stack.pop()
            } else {
                var r: Int = stack.peek()!!.value
                stack.pop()
                while (!resultStack.isEmpty() && resultStack.peek()!!.value > r) {
                    var s = resultStack.peek()!!.value
                    resultStack.pop()
                    stack.push(s)
                }
                resultStack.push(r)
            }

        }

        while (!resultStack.isEmpty()) {
            stack.push(resultStack.peek()!!.value)
            resultStack.pop()
        }
        return stack
    }
}