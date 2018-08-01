package com.lee.section03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Problem05 {
    private static Random rand = new Random();

    void shuffleArray_NAIVE(int[] intArray) {
        for (int i=0; i<intArray.length; i++) {
            int randomIndex = getRandom(0, intArray.length-1);
            swap(intArray, i, randomIndex);
        }
    }

    void shuffleArray_NOT_IN_PLACE(int[] intArray) {
        ArrayList<Integer> remainingValues = new ArrayList<Integer>();
        for (int val : intArray) {
            remainingValues.add(val);
        }

        int[] shuffledArray = new int[intArray.length];

        for (int i=0; i<shuffledArray.length; i++) {
            int remainingValuesIndex = getRandom(0, remainingValues.size() - 1);
            int val = remainingValues.get(remainingValuesIndex);
            remainingValues.remove(remainingValuesIndex);
            shuffledArray[i] = val;
        }
    }

    void shuffleArray(int[] intArray) {
        for (int i=0; i<intArray.length; i++) {
            int r = getRandom(i, intArray.length-1);
            swap(intArray, i, r);
        }
    }



    void swap(int[] intArray, int indexA, int indexB) {
        int temp = intArray[indexA];
        intArray[indexA] = intArray[indexB];
        intArray[indexB] = temp;
    }

    static int getRandom(int floor, int ceiling) {
        return rand.nextInt((ceiling - floor) + 1) + floor;
    }
}

//    index:  0  1  2  3  4 =>  0  1  2  3  4
//    value: 10 20 30 40 50 => 30 50 40 20 10
// shuffled: 20 30 10

//  a, b, c
//  a, c, b
//  b, a, c
//  b, c, a
//  c, b, a
//  c, a, b
