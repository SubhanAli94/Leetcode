package com.company.problems;

import java.util.ArrayList;
import java.util.List;

public class MaximumNumOfBalloons {
    public int maxNumberOfBalloons(String text) {
        if (text.length() < 7) {
            return 0;
        }
        char currChar;
        int _lCount = 0;
        int _oCount = 0;

        int bCount = 0;
        int aCount = 0;
        int lCount = 0;
        int oCount = 0;
        int nCount = 0;

        List<Character> relatedChars = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            currChar = text.charAt(i);

            if (currChar == 'b') {
                relatedChars.add(currChar);
                bCount++;
            } else if (currChar == 'a') {
                relatedChars.add(currChar);
                aCount++;
            } else if (currChar == 'l') {
                _lCount++;
                if (_lCount == 2) {
                    _lCount = 0;
                    relatedChars.add(currChar);
                    lCount++;
                }
            } else if (currChar == 'o') {
                _oCount++;
                if (_oCount == 2) {
                    _oCount = 0;
                    relatedChars.add(currChar);
                    oCount++;
                }
            } else if (currChar == 'n') {
                relatedChars.add(currChar);
                nCount++;
            }
        }

        if (bCount == 0 || aCount == 0 || lCount == 0 || oCount == 0 || nCount == 0) {
            return 0;
        }

        return findMinimum(bCount, aCount, lCount, oCount, nCount);
    }

    private int findMinimum(int bCount, int aCount, int lCount, int oCount, int nCount) {
        int minimum = bCount;

        if (aCount < minimum) {
            minimum = aCount;
        }
        if (lCount < minimum) {
            minimum = lCount;
        }

        if (oCount < minimum) {
            minimum = oCount;
        }

        if (nCount < minimum) {
            minimum = nCount;
        }

        return minimum;
    }

    public int maxNumberOfBalloons_improved(String text) {

        int[] chars = new int[5];
        int min = Integer.MAX_VALUE;
        for (char c : text.toCharArray()) {
            switch (c) {
                case 'b':
                    chars[0]++;
                    break;
                case 'a':
                    chars[1]++;
                    break;
                case 'l':
                    chars[2]++;
                    break;
                case 'o':
                    chars[3]++;
                    break;
                case 'n':
                    chars[4]++;
                    break;
            }
        }

        for (int i = 0; i < chars.length; i++) {
            int res = ((i == 2) || (i == 3)) ? chars[i]/2 : chars[i];
            min = Math.min(min, res);
        }
        return min;
    }
}
