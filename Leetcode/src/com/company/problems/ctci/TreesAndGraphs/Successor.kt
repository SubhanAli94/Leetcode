package com.company.problems.ctci.TreesAndGraphs

class NodeWithParent(var key: Int, var left: NodeWithParent? = null, var right: NodeWithParent? = null, var parent: NodeWithParent? = null)
class Successor {
    fun successor(node: NodeWithParent): NodeWithParent?{
        if (node.right != null){
            return leftMost(node.right!!)
        }
        if (node.parent == null) return null
        var n: NodeWithParent? = node.parent
        var k = node
        while(n != null && n!!.left != k){
            k = n
            n = n!!.parent!!
        }

        return n
    }

    private fun leftMost(right: NodeWithParent): NodeWithParent {
        var node: NodeWithParent? = right
        while(node!!.left != null){
            node = node!!.left
        }

        return node
    }
}