package com.lee;

public class Section01Problem02 {
    public static void reverse(char[] arrayOfChars) {

        int leftIndex = 0;
        int rightIndex = arrayOfChars.length - 1;

        while (leftIndex < rightIndex) {

            // swap characters
            char temp = arrayOfChars[leftIndex];
            arrayOfChars[leftIndex] = arrayOfChars[rightIndex];
            arrayOfChars[rightIndex] = temp;

            // move towards middle
            leftIndex++;
            rightIndex--;
        }
    }
}
