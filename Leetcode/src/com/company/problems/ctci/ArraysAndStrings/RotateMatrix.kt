package com.company.problems.ctci.ArraysAndStrings

import com.sun.jdi.IntegerType
import kotlin.math.ceil

class RotateMatrix {
    companion object {
        fun rotateMatrix(matrix: Array<IntArray>): Array<IntArray> {
            
            if (matrix.isEmpty()) return matrix

            for (row in matrix) {
                if (matrix.size != row.size) return matrix
            }


            var layer = 0
            var end = matrix.size - 1

            while (layer < matrix.size / 2) {

                var iterator = layer

                while (iterator < end - layer) {
                    //top-left
                    var firstElement = matrix[layer][iterator]

                    //top-left <-- bottom-left
                    matrix[layer][iterator] = matrix[end - iterator][layer]

                    //bottom-left <-- bottom-right
                    matrix[end - iterator][layer] = matrix[end - layer][end - iterator]

                    //bottom-right <-- top-right
                    matrix[end - layer][end - iterator] = matrix[iterator][end - layer]

                    //top-right <-- top-left
                    matrix[iterator][end - layer] = firstElement

                    iterator++
                }
                layer++
            }
            return matrix
        }
    }
}