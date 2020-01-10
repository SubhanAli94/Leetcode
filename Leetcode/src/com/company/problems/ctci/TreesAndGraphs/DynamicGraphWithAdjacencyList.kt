package com.company.problems.ctci.TreesAndGraphs

class GraphNode(var name: String, var neighbours: ArrayList<GraphNode> = ArrayList())
class DynamicGraphWithAdjacencyList() {
    private var nodes = ArrayList<GraphNode>()

    fun addFriend(srcPersonName: String, friendName: String) {
        var srcNode = nodes.find { it.name == srcPersonName }
        var friendNode = nodes.find { it.name == friendName }
        if (srcNode != null && friendNode != null) {
            addEdge(srcNode, friendNode)
        } else if (srcNode == null && friendNode != null) {
            srcNode = GraphNode(srcPersonName)
            nodes.add(srcNode)
            addEdge(srcNode, friendNode)
        } else if (srcNode != null && friendNode == null) {
            friendNode = GraphNode(friendName)
            nodes.add(friendNode)
            addEdge(srcNode, friendNode)
        } else {
            srcNode = GraphNode(srcPersonName)
            friendNode = GraphNode(friendName)
            nodes.add(srcNode)
            nodes.add(friendNode)
            addEdge(srcNode, friendNode)
        }
    }

    private fun addEdge(srcNode: GraphNode, friendNode: GraphNode) {
        if (!srcNode.neighbours.contains(friendNode)) {
            srcNode.neighbours.add(friendNode)
            friendNode.neighbours.add(srcNode)
        }
    }

    fun findFriends(personName: String): List<String> {
        var friends = arrayListOf<String>()
        if (nodes.any { it.name == personName }) {
            nodes.find { it.name == personName }!!.neighbours.iterator().forEach {
                friends.add(it.name)
            }
        }

        return friends
    }
}