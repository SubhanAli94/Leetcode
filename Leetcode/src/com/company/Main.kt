package com.company

import com.company.problems.ctci.ArraysAndStrings.IsPermutation
import com.company.problems.ctci.ArraysAndStrings.PalindromePermutation
import com.company.problems.ctci.ArraysAndStrings.URLify
import com.company.problems.ctci.ArraysAndStrings.UniqueCharacters


object Main {

    @JvmStatic
    fun main(args: Array<String>) {

        //a, a -> true
        //a, ab -> false
        //a*, ab -> false
        //a*, aa -> true
        //a*b, ab -> true
        //a*b*c, aabc -> true
        //.* , aabc -> true



        println(PalindromePermutation.palindromePermutationWithBitVector("Tact Coa"))


        //        System.out.println(StringPermutations.Companion.checkInclusion("aapple", "123dw"));
        //        System.out.println(RegularExpressionMatching.Companion.isMatch("a","a"));
        //        System.out.println(RegularExpressionMatching.Companion.isMatch("a","ab"));
        //        System.out.println(RegularExpressionMatching.Companion.isMatch("ab","a*"));
        //        System.out.println(RegularExpressionMatching.Companion.isMatch("aa","a*"));
        //        System.out.println(RegularExpressionMatching.Companion.isMatch("ab","a*b"));
        //        System.out.println(RegularExpressionMatching.Companion.isMatch("aabc","a*b*c"));
        //        System.out.println(RegularExpressionMatching.Companion.isMatch("aabc",".*"));
        //        System.out.println(RegularExpressionMatching.Companion.isMatch("mississippi","mis*is*p*."));
        //        System.out.println(RegularExpressionMatching.Companion.isMatch("acd",".*"));
        //        System.out.println(RegularExpressionMatching.Companion.isMatch("aaaa","ab*a*c*a"));
    }
}
