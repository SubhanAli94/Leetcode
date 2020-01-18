package com.company.problems.ctci.TreesAndGraphs

class CheckBST {
    lateinit var lastVisited: Integer
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true
        return isValid(root, null, null)
    }

    fun isValid(node: TreeNode?, max: Int?, min: Int?): Boolean {

        if (node == null) return true
        if (min != null && node.key <= min) return false
        if (max != null && node.key >= max) return false

        if (!isValid(node.left, node.key, min) ||
                !isValid(node.right, max, node.key)) return false

        return true
    }
}