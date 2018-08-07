package com.lee.section04;

public class Problem01 {
    int FindRotationPoint(String[] words) {
         int floorIndex, midIndex, ceilingIndex;
         floorIndex = 0;
         ceilingIndex = words.length-1;

         String firstWord = words[0];

         while (floorIndex < ceilingIndex) {
             midIndex = (floorIndex + ceilingIndex) / 2;
             String middleWord = words[midIndex];
             // Compare firstword with midIndex;
             if (middleWord.compareTo(firstWord) == -1) {
                 ceilingIndex = midIndex;
                 continue;
             } else {
                 floorIndex = midIndex;
                 continue;
             }
         }

         return floorIndex;
    }1
}
