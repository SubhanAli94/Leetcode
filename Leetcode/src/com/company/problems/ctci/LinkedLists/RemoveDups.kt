package com.company.problems.ctci.LinkedLists

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap

object RemoveDups {

    fun removeDups() {
        var hashSet: HashSet<Int> = HashSet()

        if (SinglyLinkedList.head != null) {
            var prev = SinglyLinkedList.head
            var curr = SinglyLinkedList.head

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


    fun removeDupsWithoutBuffer() {
        var sb = StringBuilder("s")
        (sb.indices).forEach {

        }
        println(sb.toString() == "")
        println(String(sb) == "")
        var current = SinglyLinkedList.head!!
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