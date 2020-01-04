package com.company.problems.ctci.TreesAndGraphs

class TrieNode(var hashMap: HashMap<Char, TrieNode> = HashMap(), var isWord: Boolean = false,
               var prefix: String = "")

class Trie {
    var node = TrieNode()

    fun addWord(word: String) {
        var tempNode: TrieNode? = node
        var i = 0
        while (i < word.length) {
            if (!tempNode!!.hashMap.containsKey(word[i])) {
                tempNode.hashMap[word[i]] = TrieNode(prefix = word.substring(0, i + 1))
            }
            tempNode = tempNode.hashMap[word[i]]
            i++

            if (i == word.length) {
                tempNode!!.isWord = true
            }
        }
    }

    fun findWord(word: String): Boolean {
        var tempNode: TrieNode? = node
        var i = 0
        while (i < word.length) {
            if (tempNode!!.hashMap.containsKey(word[i])) {
                tempNode = tempNode.hashMap[word[i]]
            } else {
                return false
            }
            i++
        }
        return tempNode!!.isWord
    }
}

