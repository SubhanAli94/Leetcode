package com.company.problems.ctci.TreesAndGraphs

class MinimalTree {

    fun minimalTree(arr: IntArray): TreeNode? {
        if (arr.isEmpty()) return null

        var tree = makeTree(arr, 0, arr.size - 1)
        displayTree(tree)
        return tree
    }

    private fun makeTree(arr: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) {
            return null
        }

        var mid = (start + end) / 2
        var node = TreeNode(arr[mid])
        node.left = makeTree(arr, start, mid - 1)
        node.right = makeTree(arr, mid + 1, end)

        return node
    }

    fun displayTree(node: TreeNode?){
        if (node == null) return
        print(node.key)
        displayTree(node.left)
        displayTree(node.right)
    }
}