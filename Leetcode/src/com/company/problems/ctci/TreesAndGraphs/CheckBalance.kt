package com.company.problems.ctci.TreesAndGraphs

class CheckBalance {

    fun isBalanced(root: TreeNode?): Boolean {
        if(root == null) return true
        var h = getHeight(root)

        return h != Integer.MIN_VALUE
    }

    fun getHeight(node: TreeNode?): Int{
        if(node == null) return -1

        var lh = getHeight(node.left)
        if(lh == Integer.MIN_VALUE) return Integer.MIN_VALUE

        var rh = getHeight(node.right)
        if(rh == Integer.MIN_VALUE) return Integer.MIN_VALUE



        if(Math.abs(lh - rh) > 1){
            return Integer.MIN_VALUE
        }else{
            return Math.max(lh, rh) + 1
        }

    }
}