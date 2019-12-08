package com.company.problems.ctci.ArraysAndStrings

object ZeroMatrix {
    fun zeroMatrix(matrix: Array<IntArray>): Array<IntArray> {
        if (matrix.isEmpty()) return matrix

        var firstColumnHasZero = false
        var firstRowHasZero = false

        (matrix.indices).forEach { i ->
            (matrix[i].indices).forEach { j ->
                if (matrix[i][j] == 0) {

                    if (i == 0) firstRowHasZero = true
                    if (j == 0) firstColumnHasZero = true
                    matrix[i][0] = 0
                    matrix[0][j] = 0
                }
            }
        }

        (1 until matrix.size).forEach { i ->
            (1 until matrix[i].size).forEach { j ->
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0
                }
            }
        }

        if (firstColumnHasZero) {
            (matrix.indices).forEach {
                matrix[it][0] = 0
            }
        }

        if (firstRowHasZero) {
            (matrix[0].indices).forEach {
                matrix[0][it] = 0
            }
        }

        return matrix
    }
}