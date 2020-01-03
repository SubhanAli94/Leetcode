package com.company.problems.ctci.TreesAndGraphs

class MinHeap() {
    var heapArray = arrayListOf<Int>()
    fun insert(key: Int) {
        if (heapArray.size == 0) {
            heapArray.add(key)
        } else {
            heapArray.add(key)
            bubbleUp(key)
        }
    }

    private fun bubbleUp(key: Int) {
        var c = heapArray.size - 1

        while (c > 0) {
            var p: Int = (c - 1) / 2

            if (heapArray[p] > key) {
                var temp = heapArray[p]
                heapArray[p] = key
                heapArray[c] = temp

                c = p
            } else
                break
        }
    }

    fun deleteKey(key: Int) {
        if (heapArray.contains(key)) {

            if (heapArray.size > 1) {
                if (heapArray.indexOf(key) == heapArray.size - 1) {
                    heapArray.remove(key)
                } else {
                    var index = heapArray.indexOf(key)
                    heapArray[index] = heapArray[heapArray.size - 1]
                    heapArray.removeAt(heapArray.size - 1)
                    bubbleDown(index)
                }
            } else {
                heapArray.remove(key)
            }
        }
    }

    private fun bubbleDown(index: Int) {

        var p = index

        while (p < heapArray.size) {
            var c1 = 2 * p + 1
            var c2 = c1 + 1
            if (c1 < heapArray.size && c2 < heapArray.size) {
                p = if (heapArray[c1] < heapArray[c2]) {
                    replaceElement(p, c1)
                } else {
                    replaceElement(p, c2)
                }
                continue
            } else if (c1 < heapArray.size) {
                replaceElement(p, c1)
                break
            }
            break
        }
    }

    private fun replaceElement(p: Int, c: Int): Int {
        var p1 = p
        if (heapArray[p1] > heapArray[c]) {
            var temp = heapArray[c]
            heapArray[c] = heapArray[p1]
            heapArray[p1] = temp
        }

        p1 = c
        return p1
    }


    fun display() {
        (0 until heapArray.size).forEach {
            print(" " + heapArray[it] + " ")
        }
    }
}