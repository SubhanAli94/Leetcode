package com.company.problems.ctci.TreesAndGraphs

import java.util.*

class BreadthFirstSearch {
    fun searchFriend(personName: String, root: GraphNode) {
        if (personName == root.name) print("Found!!")
        var queue: Queue<GraphNode> = LinkedList<GraphNode>()
        root.visited = true
        queue.add(root)
        while (!queue.isEmpty()) {
            var node = queue.remove()
            if (node.name == personName) {
                print("Found!!")
            } else {
                var l = node.neighbours.filter { !it.visited }
                l.forEach {
                    it.visited = true
                    queue.add(it)
                }
            }
        }
    }
}