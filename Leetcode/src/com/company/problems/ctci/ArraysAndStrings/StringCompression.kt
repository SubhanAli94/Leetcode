package com.company.problems.ctci.ArraysAndStrings

class StringCompression {
    companion object {
        //with backward lookup
        fun stringCompression(s: String): String {

            if (s.isNotEmpty()) {
                var resultString = StringBuilder()

                var count = 1
                for (c in s.withIndex()) {
                    if (resultString.isEmpty()) {
                        resultString.append(c.value)
                    } else {
                        if (resultString[resultString.length - 1] == c.value) {
                            count++
                        } else {
                            resultString.append(count)
                            resultString.append(c.value)
                            count = 1
                        }
                    }
                }

                if (resultString.length < s.length) {
                    resultString.append(count)
                    return resultString.toString()
                }
            }
            return s
        }

        //with forward lookup
        fun stringCompressionWithForwardLookup(s: String): String {

            if (s.isNotEmpty()) {
                var resultString = StringBuilder()

                var count = 0
                for (c in s.withIndex()) {
                    count++
                    if (c.index + 1 >= s.length || s[c.index] != s[c.index + 1]) {
                        resultString.append(c.value)
                        resultString.append(count)
                        count = 0
                    }
                }

                if (resultString.length < s.length) {
                    return resultString.toString()
                }
            }
            return s
        }
    }
}