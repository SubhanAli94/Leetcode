package com.company.problems.ctci.ArraysAndStrings

import java.util.*

class IsPermutation() {
    companion object {
        //By sorting character arrays
        fun isPermutation(s: String, t: String): Boolean {
            if (s.length != t.length) return false

            var sArr = s.toCharArray()
            var tArr = t.toCharArray()

            Arrays.sort(sArr)
            Arrays.sort(tArr)

            if (sArr.contentEquals(tArr)) return true

            return false
        }

        //By mapping characters' count in array of character
        //Assumption: Character set is ASCII
        fun isPermutationWithCharCount(s: String, t: String): Boolean {

            if (s.length != t.length) return false
            var intArr = IntArray(128)

            for (c in s) {
                intArr[c.toInt()]++
            }

            for (c in t) {
                intArr[c.toInt()]--
                if (intArr[c.toInt()] < 0) {
                    return false
                } else {
                    intArr[c.toInt()]--
                }
            }
            return true
        }
    }
}