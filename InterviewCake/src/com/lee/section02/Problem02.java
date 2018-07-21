package com.lee.section02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem02 {
    boolean IsAPalindrome_SetSolution(String input) {
        Set<Character> letterSet = new HashSet<>();

        for (char c : input.toCharArray()) { // letterSet = { }
            if (letterSet.contains(c)) {
                letterSet.remove(c);
                continue;
            }
            letterSet.add(c);
        }

        // after the loop
        if (letterSet.size() > 1) return false;
        return true;
    }

    boolean IsAPalindrome_MapSolution(String input) {
        Map<Character, Integer> lettersMap = new HashMap<>();

        for (char c : input.toCharArray()) { // letterMap = { c => 2,
                                             //               i => 2,
                                             //               v => 1 }
            int cnt = 0;
            if (lettersMap.containsKey(c)) {
                cnt = lettersMap.get(c);
            }
            cnt++;
            lettersMap.put(c, cnt);
        }

        int oddNumberCount = 0;
        for (Map.Entry<Character, Integer> entry : lettersMap.entrySet()) {
            int val = entry.getValue();
            if (val % 2 != 0) oddNumberCount++;
            if (oddNumberCount > 1) return false;
        }

        return true;
    }
}

// "civic" should return true
// "ivicc" should return true
// "boob" should return true
// "babboobbab" should return true { b => 6, a => 2, o => 2 }

// "babobbab" should return false { b => 5, a => 2, o => 1 }
// "civil" should return false
// "livci" should return false
