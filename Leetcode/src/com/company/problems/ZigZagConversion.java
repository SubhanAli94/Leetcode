package com.company.problems;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() < 3){
            return s;
        }

        int length = s.length();
        StringBuilder sb = new StringBuilder();
        int interval = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j+i < length; j += interval) {
                sb.append(s.charAt(j + i));

                if (i != 0 && i != numRows - 1 && j + interval - i < length){
                    sb.append(s.charAt(j+interval - i));
                }
            }
        }

        return sb.toString();
    }
}
