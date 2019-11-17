package com.company.problems.ctci.ArraysAndStrings

class URLify{
    companion object {
        fun urlify(s: CharArray, len: Int): String? {
            if (s.isEmpty()) return null


            var spaceCount = s.count{ c -> c == ' '}
            var charArr = CharArray(len + spaceCount * 2)

            var i = charArr.size
            for(j in s.lastIndex downTo 0){

                if(s[j].equals(' ')){
                    charArr[--i] = '0'
                    charArr[--i] = '2'
                    charArr[--i] = '%'
                }else {
                    charArr[--i] = s[j]
                }
            }
            return String(charArr)
        }
    }
}