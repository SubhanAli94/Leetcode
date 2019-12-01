package com.company.problems.ctci.ArraysAndStrings


class PalindromePermutation {
    companion object {
        fun palindromePermutation(s: String): Boolean {
            var arr = IntArray(128)
            var ls = s.toLowerCase()
            for (c in ls) {
                //space characters are ignored
                if (c.toInt() != 32) {
                    arr[c.toInt()]++
                }
            }
            var isAlreadyOddFound = false
            for (n in arr) {
                if (n % 2 != 0) {
                    if (!isAlreadyOddFound) {
                        isAlreadyOddFound = true
                    } else {
                        return false
                    }
                }
            }
            return true
        }

        //With Bit Vector
        fun palindromePermutationWithBitVector(s: String): Boolean {

            var vector = 0
            var ls = s.toLowerCase()
            for (c in ls) {
                var charNum = 'a'.toInt() - c.toInt()
                if (c.toInt() != 32) {
                    vector = vector xor (1 shl charNum)
                }
            }
            return (vector and (vector - 1)) == 0
        }
    }
}