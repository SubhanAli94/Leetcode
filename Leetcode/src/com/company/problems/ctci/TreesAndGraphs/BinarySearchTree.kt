package com.company.problems.ctci.TreesAndGraphs

class Node(var key: Int, var left: Node? = null, var right: Node? = null)
class BinarySearchTree(var rootNode: Node) {

    fun insert(key: Int, root: Node) {
        if (rootNode == null) {
            rootNode = Node(key)
        } else {
            insertKey(key, root)
        }
    }

    private fun insertKey(key: Int, root: Node?): Node {
        if (root == null) {
            return Node(key)
        }

        if (key <= root.key) {
            root.left = insertKey(key, root.left)
        } else {
            root.right = insertKey(key, root.right)
        }

        return root
    }

}