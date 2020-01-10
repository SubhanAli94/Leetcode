package com.company.problems.ctci.TreesAndGraphs

class GraphWithAdjacencyList(var hashMap: HashMap<Int, ArrayList<Int>> = HashMap()) {
    fun addEdge(src: Int, dest: Int) {
        if (hashMap.containsKey(src) && hashMap.containsKey(dest)) {
            addElement(hashMap[src]!!, dest)
            addElement(hashMap[dest]!!, src)
        } else if (hashMap.containsKey(src) && !hashMap.containsKey(dest)) {
            addElement(hashMap[src]!!, dest)
            addArray(dest, src)
        } else if (!hashMap.containsKey(src) && hashMap.containsKey(dest)) {
            addElement(hashMap[dest]!!, src)
            addArray(src, dest)
        } else if (!hashMap.containsKey(src) && !hashMap.containsKey(dest)) {
            addArray(src, dest)
            addArray(dest, src)
        }
    }

    private fun addElement(arr: ArrayList<Int>, element: Int) {
        if (!arr.contains(element)) {
            arr.add(element)
        }
    }

    private fun addArray(src: Int, dest: Int) {
        var arr = ArrayList<Int>()
        arr.add(dest)
        hashMap[src] = arr
    }

    fun findNeighbours(vertex: Int): ArrayList<Int>? {
        return if (hashMap.containsKey(vertex)) {
            hashMap[vertex]
        } else {
            null
        }
    }
}