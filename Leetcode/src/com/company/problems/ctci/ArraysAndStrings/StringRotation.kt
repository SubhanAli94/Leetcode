package com.company.problems.ctci.ArraysAndStrings

import java.lang.StringBuilder

object StringRotation {
    fun isSubString(s1: String, s2: String): Boolean {

        if (s1.length != s2.length) return false

        var s2Builder = StringBuilder(s2)

        s2Builder.append(s2Builder)
        return s2Builder.contains(s1)
    }
}