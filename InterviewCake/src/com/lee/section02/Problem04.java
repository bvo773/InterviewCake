package com.lee.section02;

import java.util.HashMap;

public class Problem04 {
    int[] sortScores(int[] unsortedScores, int highestPossibleScore) {
        HashMap<Integer, Integer> scoreCountMap = new HashMap<>();

        for (int score : unsortedScores) {
            if (scoreCountMap.containsKey(score)) {
                int count = scoreCountMap.get(score);
                scoreCountMap.put(score, count + 1);
            }
            else {
                scoreCountMap.put(score, 1);
            }
        }

        int[] sortedScores = new int[unsortedScores.length];
        int sortedIndex = 0;
        for (int i = highestPossibleScore; i >= 0; i--) {
            if (scoreCountMap.containsKey(i)) {
                int count = scoreCountMap.get(i); // get key
                for (int j = 0; j < count; j++) {
                    sortedScores[sortedIndex++] = i;
                }
            }
        }

        return sortedScores;
    }
}

// Time : O(n + c) => O(n)
// Space: O(n + n) => O(2n) => O(n)


// between 0 and highestPossibleScore

// unsortedScores = {37, 89, 41, 65, 91, 53, 89, 100, 100, 100};
// highestPossibleScore = 100;

// sortedScores: [ 100, 100, 100, 89 ]
