package com.company.problems.ctci.LinkedLists

import com.company.problems.ctci.Utils.Node
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap

object RemoveDups {

    fun removeDups(head: Node) {
        var hashSet: HashSet<Int> = HashSet()

        if (head != null) {
            var prev = head
            var curr: Node? = head

            while (curr != null) {
                if (!hashSet.contains(curr.value)) {
                    hashSet.add(0)
                    prev = curr
                } else {
                    prev!!.next = curr.next
                }
                curr = curr.next
            }
        }
    }


    fun removeDupsWithoutBuffer(head: Node) {
        var sb = StringBuilder("s")
        (sb.indices).forEach {

        }
        println(sb.toString() == "")
        println(String(sb) == "")
        var current = head!!
        while (current.next != null) {
            var runner = current
            while (runner.next != null) {
                if (runner.next!!.value == current.value) {
                    runner.next = runner.next!!.next
                } else {
                    runner = runner.next!!
                }
            }

            current = current.next!!
        }
    }
}