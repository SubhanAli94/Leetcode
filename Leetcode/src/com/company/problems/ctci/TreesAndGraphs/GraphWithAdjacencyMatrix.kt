package com.company.problems.ctci.TreesAndGraphs

class GraphWithAdjacencyMatrix(var size: Int) {
    var matrix = Array(size) { BooleanArray(size) }

    fun addEdge(src: Int, dest: Int) {
        matrix[src][dest] = true
        matrix[dest][src] = true
    }

    fun findNeighbours(vertex: Int): List<Int> {
        var list = arrayListOf<Int>()
        (matrix[vertex].indices).forEach {
            if (matrix[vertex][it]) list.add(it)
        }
        return list
    }
}