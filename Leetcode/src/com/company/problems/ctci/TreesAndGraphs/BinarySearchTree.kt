package com.company.problems.ctci.TreesAndGraphs

class BinarySearchTree(var rootNode: TreeNode) {

    fun insert(key: Int, root: TreeNode) {
        if (rootNode == null) {
            rootNode = TreeNode(key)
        } else {
            insertKey(key, root)
        }
    }

    private fun insertKey(key: Int, root: TreeNode?): TreeNode {
        if (root == null) {
            return TreeNode(key)
        }

        if (key <= root.key) {
            root.left = insertKey(key, root.left)
        } else {
            root.right = insertKey(key, root.right)
        }

        return root
    }

}