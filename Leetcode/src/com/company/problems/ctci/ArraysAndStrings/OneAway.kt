package com.company.problems.ctci.ArraysAndStrings

class OneAway{
    companion object{
        fun oneAway(s: String, t: String): Boolean{
            if (s == t) return true
            if (s.length == t.length - 1 || s.length == t.length + 1 || s.length == t.length){

                var arr = IntArray(128)
                for(c in s){
                    arr[c.toInt()]++
                }

                for(c in t){
                    arr[c.toInt()]--
                }

                var countOfOne = arr.count{x -> x == 1}
                if (countOfOne == 1 || countOfOne == 2){
                    return true
                }
            }
            return false
        }
    }
}