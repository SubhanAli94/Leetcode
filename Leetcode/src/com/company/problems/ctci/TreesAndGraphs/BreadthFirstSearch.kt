package com.company.problems.ctci.TreesAndGraphs

import java.util.*

class BreadthFirstSearch {
    fun searchFriend(personName: String, root: GraphNode) {
        if (personName == root.name) print("Found!!")
        var queue: Queue<GraphNode> = LinkedList<GraphNode>()
        root.state = State.Visited
        queue.add(root)
        while (!queue.isEmpty()) {
            var node = queue.remove()

            node.neighbours.forEach {
                if (it.state == State.Unvisited) {
                    if (it.name == personName) {
                        print("Found!!")
                        return
                    }
                    it.state = State.Visiting
                    queue.add(it)
                }
            }
            node.state = State.Visited
        }
    }
}