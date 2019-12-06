package com.company.problems.easy


class BinaryGap {
    companion object {
        fun binaryGap(N: Int): Int {
            if (N < 1) return 0

            var dist = 0
            var windowStarted = false
            var maxDist = 0
            var tempNum = N

            while (tempNum != 0) {
                if (tempNum and 1 == 0) {
                    if (windowStarted) {
                        dist++
                    }
                } else {
                    if (!windowStarted) {
                        windowStarted = true
                    } else {
                        ++dist
                        if (dist > maxDist) {
                            maxDist = dist
                        }
                        dist = 0
                    }
                }
                tempNum = tempNum shr 1
            }
            return maxDist
        }
    }
}