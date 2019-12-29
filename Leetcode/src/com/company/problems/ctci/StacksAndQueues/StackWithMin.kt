package com.company.problems.ctci.StacksAndQueues

import com.company.problems.ctci.Utils.Node
import java.lang.NullPointerException

class StackWithMin : Stack() {

    private var stack = Stack()

    override fun push(value: Int) {

        when (head) {
            null -> {
                head = Node(value)
                stack.push(value)
            }
            else -> {
                var temp = head
                head = Node(value)
                head!!.next = temp

                if (stack.peek()!!.value > value) {
                    stack.push(value)
                }
            }
        }
    }

    override fun pop() {
        if (!stack.isEmpty() && !isEmpty()) {
            if (stack.peek()!!.value == peek()!!.value) {
                stack.pop()
            }
        }

        super.pop()
    }

    fun min(): Int? {
        return stack.peek()?.value
    }
}