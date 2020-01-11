package com.company.problems.ctci.TreesAndGraphs

class DirectedGraphWithAdjacencyList {
    var nodes = arrayListOf<GraphNode>()

    fun addFriend(srcPerson: String, friend: String) {
        var srcPersonNode = nodes.find { it.name == srcPerson }
        var friendNode = nodes.find { it.name == friend }

        if (srcPersonNode != null && friendNode == null) {
            friendNode = GraphNode(friend)
            nodes.add(friendNode)
        } else if (srcPersonNode == null && friendNode != null) {
            srcPersonNode = GraphNode(srcPerson)
            nodes.add(srcPersonNode)
        } else if (srcPersonNode == null && friendNode == null) {
            srcPersonNode = GraphNode(srcPerson)
            friendNode = GraphNode(friend)
            nodes.add(srcPersonNode)
            nodes.add(friendNode)
        }

        addEdge(srcPersonNode!!, friendNode!!)
    }

    private fun addEdge(srcPersonNode: GraphNode, friendNode: GraphNode) {
        if (!srcPersonNode.neighbours.contains(friendNode)) {
            srcPersonNode.neighbours.add(friendNode)
        }
    }

    fun findFriend(friendName: String, rootNode: GraphNode) {
        if (rootNode.neighbours.any { it.name == friendName }) {
            print("Friend Exists!")
        }else{
            print("Friend does not Exist!")
        }
    }
}