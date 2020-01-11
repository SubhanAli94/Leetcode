package com.company.problems.ctci.TreesAndGraphs

class DepthFirstSearch {
    fun searchFriend(friendName: String, root: GraphNode) {
        if (root.name == friendName) print("Found!!")
        if (root.neighbours.size == 0) print("Not Found!!")
        else {

            search(friendName, root)
        }
    }

    private fun search(friendName: String, root: GraphNode): Boolean {
        if (root.name == friendName) {
            print("Found!!")
            return true
        }
        if (root.neighbours.size == 0) {
            return false
        }
        root.state = State.Visiting
        root.neighbours.forEach {
            if (it.state == State.Unvisited) {
                var found = search(friendName, it)
                if (found) {
                    return true
                }
            }
        }

        root.state = State.Visited
        return false
    }
}