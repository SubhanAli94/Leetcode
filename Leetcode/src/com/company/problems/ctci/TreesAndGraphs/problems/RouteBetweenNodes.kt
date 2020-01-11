package com.company.problems.ctci.TreesAndGraphs.problems

import com.company.problems.ctci.TreesAndGraphs.BreadthFirstSearch
import com.company.problems.ctci.TreesAndGraphs.GraphNode
import java.util.*

class RouteBetweenNodes {
    fun findRouteWithDfs(srcNode: GraphNode, destNode: GraphNode) {
        if (dfs(destNode, srcNode)) println("Route Exists!")
        else
            println("Route Does Not Exist!")
    }

    fun findRouteWithBfs(srcNode: GraphNode, destNode: GraphNode) {
        bfs(destNode, srcNode)
    }

    private fun bfs(destNode: GraphNode, srcNode: GraphNode) {
        var queue: Queue<GraphNode> = LinkedList()
        queue.add(srcNode)

        while (!queue.isEmpty()) {
            var node = queue.remove()
            if (node.name == destNode.name) {
                println("Route Exists!!")
                return
            } else {
                node.neighbours.filter { !it.visited }.forEach {
                    it.visited = true
                    queue.add(it)
                }
            }
        }

        println("Route Does Not Exists")
    }

    private fun dfs(destNode: GraphNode, srcNode: GraphNode): Boolean {
        if (srcNode == null) return false
        if (srcNode.name == destNode.name) return true

        srcNode.neighbours.forEach {
            var found = dfs(destNode, it)
            if (found) return true
        }

        return false
    }
}