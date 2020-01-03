package com.company.problems.ctci.TreesAndGraphs

class MaxHeap {
    var heapArray = arrayListOf<Int>()
    fun insert(key: Int) {

        if (heapArray.size == 0) {
            heapArray.add(key)
        } else {
            heapArray.add(key)
            bubbleUp()
        }
    }

    private fun bubbleUp() {
        var c = heapArray.size - 1

        while (c > 0) {
            var p = (c - 1) / 2
            if (heapArray[p] < heapArray[c]) {
                replaceWithParent(p, c)
                c = p
            }else{
                break
            }
        }
    }

    private fun replaceWithParent(p: Int, c: Int) {
        var temp = heapArray[p]
        heapArray[p] = heapArray[c]
        heapArray[c] = temp
    }

    fun deleteKey(key: Int) {
        var index = heapArray.indexOf(key)
        heapArray[index] = heapArray[heapArray.size - 1]
        heapArray.removeAt(heapArray.size - 1)

        bubbleDown(index)
    }

    private fun bubbleDown(index: Int) {

        var p = index

        while (p < heapArray.size) {
            var c1 = 2 * p + 1
            if (c1 < heapArray.size) {
                var c2 = c1 + 1
                p = if (c2 < heapArray.size) {
                    if (heapArray[c1] > heapArray[c2]) {
                        replaceWithChild(c1, p)
                    } else {
                        replaceWithChild(c2, p)
                    }
                } else {
                    replaceWithChild(c1, p)
                }
            }else{
                break
            }
        }
    }

    private fun replaceWithChild(c: Int, p: Int): Int {
        var temp = heapArray[c]
        heapArray[c] = heapArray[p]
        heapArray[p] = temp

        return c
    }

    fun display() {
        (0 until heapArray.size).forEach {
            print(" " + heapArray[it] + " ")
        }
    }
}