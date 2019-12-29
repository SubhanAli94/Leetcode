package com.company.problems.ctci.LinkedLists

import com.company.problems.ctci.Utils.Node

object SumLists {
    fun sumLists(num1: Node, num2: Node): Node? {
        if (num1 == null) return num2
        if (num2 == null) return num1

        var carry = 0
        var numb1: Node? = num1
        var numb2: Node? = num2
        var ans: Node? = null
        var ansRunner = ans

        while (numb1 != null && numb2 != null) {

            var sum = numb1.value + numb2.value + carry
            carry = sum / 10
            var tempAns = sum % 10

            if (ans == null) {
                ans = Node(tempAns)
                ansRunner = ans
            } else {
                ansRunner!!.next = Node(tempAns)
                ansRunner = ansRunner.next
            }

            numb1 = numb1.next
            numb2 = numb2.next
        }

        if (numb1 == null && numb2 != null) {
            while (numb2 != null) {
                var sum = numb2!!.value + carry
                carry = sum / 10
                var tempAns = sum % 10

                ansRunner!!.next = Node(tempAns)
                ansRunner = ansRunner.next

                numb2 = numb2.next
            }
        }

        if (numb1 != null && numb2 == null) {
            while (numb1 != null) {
                var sum = numb1!!.value + carry
                carry = sum / 10
                var tempAns = sum % 10

                ansRunner!!.next = Node(tempAns)
                ansRunner = ansRunner.next

                numb1 = numb1.next
            }
        }

        if (carry > 0) {
            ansRunner!!.next = Node(carry)
        }

        return ans
    }
}