package com.company.problems;

public class LongestPalindromeSubString {
    int maxLength;
    int start;
    public String longestPalindromeSubString(String input) {
        int len = input.length();
        if (len < 2) {
            return input;
        }

        for (int i = 0; i < len - 1; i++) {
            expand(input, i, i);
            expand(input, i, i + 1);
        }
        return input.substring(start, start + maxLength);
    }

    public void expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (maxLength < j - i - 1){
            maxLength = j - i -1;
            start = i + 1;
        }
    }
}
