package com.company.problems.ctci

class ArraysAndStrings {
    companion object {

        //using Boolean Array
        fun uniqueCharacters(inputStr: String): Boolean {
            if (inputStr.isNullOrEmpty() || inputStr.length > 128) return false

            var tempInputStr = inputStr.toLowerCase()

            var charArray = BooleanArray(128)

            for (c in tempInputStr) {
                println(c)
                if (charArray[c.toInt()])
                    return false
                else
                    charArray[c.toInt()] = true
            }
            return true
        }

        //using Char arrayList
        fun uniqueCharactersWithArrayList(inputStr: String): Boolean {
            if (inputStr.isNullOrEmpty()) return false

            var tempInputStr = inputStr.toLowerCase()

            var list = mutableListOf<Char>()

            for (c in tempInputStr) {
                if (list.contains(c)) {
                    return false
                } else {
                    list.add(c)
                }
            }

            return true
        }

        //using Bitwise Operation | Assumption: string only contains lowercase alphabets
        fun uniqueCharactersWithBitwiseOperation(inputStr: String): Boolean {
            var checker = 0 //32 bits are set to zero

            for (c in inputStr) {
                var charNum = c.toInt() - 'a'.toInt()

                //check if this bit is already set to 1 or not
                if (checker and (1 shl charNum) > 0) return false

                //shift left 1 by charNum to turn that bit ON then OR with checker to turn that bit on in checker
                checker = checker or (1 shl charNum)
            }

            return true
        }
    }
}