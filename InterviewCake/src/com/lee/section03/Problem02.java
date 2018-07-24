package com.lee.section03;

public class Problem02 {
    public static int FindHighestProducOfThreeIntegers(int[] arrayOfInts) {
        int minFactor1 = arrayOfInts[0];
        int minFactor2 = arrayOfInts[1];

        int maxFactor1 = arrayOfInts[0];
        int maxFactor2 = arrayOfInts[1];

        int minProductOfTwoFactors = arrayOfInts[0] * arrayOfInts[1];
        int maxProductOfTwoFactors = arrayOfInts[0] * arrayOfInts[1];

        int maxProduct = maxProductOfTwoFactors * arrayOfInts[2];

        // [ −10, 5, 3, -6, 2 ]

        for (int i = 2; i < arrayOfInts.length; i++) {
            int factor = arrayOfInts[i];
            int prod1 = factor * minProductOfTwoFactors;
            int prod2 = factor * maxProductOfTwoFactors;
            int prod = Math.max(prod1, prod2);
            maxProduct = Math.max(prod, maxProduct);

            int[] newMaxFactors = GetTopTwoMax(factor, maxFactor1, maxFactor2);
            maxFactor1 = newMaxFactors[0];
            maxFactor2 = newMaxFactors[1];
            maxProductOfTwoFactors = maxFactor1 * maxFactor2;

            int[] newMinFactors = GetTopTwoMin(factor, minFactor1, minFactor2);
            minFactor1 = newMinFactors[0];
            minFactor2 = newMinFactors[1];
            minProductOfTwoFactors = minFactor1 * minFactor2;
        }

        return maxProduct;
    }


// [ 10, 10, 20, 30, 2 ]

// [ −10, −10, 1, 3, 2 ]

// [ −10, 5, 3, -6, 2 ]


    static int[] GetTopTwoMax(int x, int y, int z) {
        // x=7 y=5 z=1
        int firstMax;
        int secondMax;
        if (x > y) {
            firstMax = x;
            secondMax = y;
        }
        else {
            firstMax = y;
            secondMax = x;
        }

        if (z > secondMax) {
            secondMax = z;
        }

        return new int[] {firstMax, secondMax};
    }

    static int[] GetTopTwoMin(int x, int y, int z) {
        // x=7 y=5 z=1
        int firstMin;
        int secondMin;
        if (x < y) {
            firstMin = x;
            secondMin = y;
        }
        else {
            firstMin = y;
            secondMin = x;
        }

        if (z < secondMin) {
            secondMin = z;
        }

        return new int[] {firstMin, secondMin};
    }
}
