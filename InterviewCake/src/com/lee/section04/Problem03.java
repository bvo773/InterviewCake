package com.lee.section04;

import java.util.HashMap;

public class Problem03 {
    int[] SortScores(int[] unsortedScores, int highestPossibleScore) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int score : unsortedScores) {
            if(map.containsKey(score)) {
                map.put(score, map.get(score)+1);
            }
            else {
                map.put(score, 1);
            }
        }

        int[] sortedScores = new int[unsortedScores.length];
        int j = 0;

        for (int score = highestPossibleScore; score >= 0; score--) {
            if(map.containsKey(score)) {
                int numOccurences = map.get(score);
                for(int k = 0; k < numOccurences; k++) {
                    sortedScores[j++] = score;
                }
            }
        }
        return sortedScores;
    }

    int[] SortScores_Array(int[] unsortedScores, int highestPossibleScore) {
        int[] scoreCount = new int[highestPossibleScore+1]; // 0 thru 100
        for (int score : unsortedScores) {
            scoreCount[score]++;
        }

        int[] sortedScores = new int[unsortedScores.length];
        int j = 0;

        for (int score = highestPossibleScore; score >= 0; score--) {
            int numOccurences = scoreCount[score];
            for(int k = 0; k < numOccurences; k++) {
                sortedScores[j++] = score;
            }
        }
        return sortedScores;
    }
}

// 0 to 100
// highestPossibleScore 100
// int[] unsortedScores = {37, 89, 41, 65, 91, 53, 41};
// sortedScores: [91, 89, 65, 53, 41, 41, 37]