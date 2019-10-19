package com.company.problems;

import java.util.*;
import java.util.stream.Collectors;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        int length = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {

            if (map.containsKey(arr[i])) {
                //increment value
                int value = map.get(arr[i]);
                map.put(arr[i], ++value);
            } else {
                //add key with value 1
                map.put(arr[i], 1);
            }
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(null);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == list.get(i+1)){
                return false;
            }
        }
        return true;
    }
}
