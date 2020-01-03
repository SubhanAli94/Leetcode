package com.company.problems.ctci.TreesAndGraphs

object Traversals{
    fun inOrder(root: Node?){
        if (root == null) return

        inOrder(root.left)
        print(" " + root.key + " ")
        inOrder(root.right)
    }

    fun preOrder(root: Node?){
        if (root == null) return
        print(" " + root.key + " ")
        preOrder(root.left)
        preOrder(root.right)
    }

    fun postOrder(root: Node?){
        if (root == null) return

        postOrder(root.left)
        postOrder(root.right)
        print(" " + root.key + " ")
    }
}