package com.company.problems.ctci.TreesAndGraphs

import java.util.*
import kotlin.collections.ArrayList

class ListOfDepths {
    fun listOfDepths(root: TreeNode): List<List<Int>> {
        if (root == null) return ArrayList()

        var result = mutableListOf<List<Int>>()
        var parents = mutableListOf<TreeNode>()
        var currents = mutableListOf<TreeNode>()
        var levelResult = mutableListOf<Int>()
        currents.add(root!!)
        levelResult.add(root!!.key)

        while (currents.size > 0) {
            result.add(levelResult)
            levelResult = mutableListOf<Int>()
            parents = currents
            currents = mutableListOf<TreeNode>()

            (0 until parents.size).forEach {
                if (parents[it].left != null) {
                    currents.add(parents[it].left!!)
                    levelResult.add(parents[it].left!!.key)
                }
                if (parents[it].right != null) {
                    currents.add(parents[it].right!!)
                    levelResult.add(parents[it].right!!.key)
                }
            }

        }

        return result
    }
}