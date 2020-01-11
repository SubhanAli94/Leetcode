package com.company.problems.ctci.TreesAndGraphs.problems

import com.company.problems.ctci.TreesAndGraphs.GraphNode
import com.company.problems.ctci.TreesAndGraphs.State
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

            node.neighbours.forEach {
                if (it.state == State.Unvisited) {
                    if (it.name == destNode.name) {
                        println("Route Exists!!")
                        return
                    }

                    it.state = State.Visiting
                    queue.add(it)
                }
            }

            node.state = State.Visited
        }

        println("Route Does Not Exists")
    }

    private fun dfs(destNode: GraphNode, srcNode: GraphNode): Boolean {
        if (srcNode == null) return false
        if (srcNode.name == destNode.name) return true

        srcNode.state = State.Visiting

        srcNode.neighbours.forEach {
            if (it.state == State.Unvisited) {
                var found = dfs(destNode, it)
                if (found) return true
            }
        }

        srcNode.state = State.Visited
        return false
    }
}