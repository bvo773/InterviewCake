package com.lee.section03;

public class Problem02 {
    public static int FindHighestProducOfThreeIntegers(int[] arrayOfInts) {
        int minFactor = Math.min(arrayOfInts[0], arrayOfInts[1]);
        int maxFactor = Math.max(arrayOfInts[0], arrayOfInts[1]);

        int minProductOfTwoFactors = arrayOfInts[0] * arrayOfInts[1];
        int maxProductOfTwoFactors = arrayOfInts[0] * arrayOfInts[1];

        int maxProduct = arrayOfInts[0] * arrayOfInts[1] * arrayOfInts[2];

        // [ −10, 5, 3, -6, 2 ] x * y * z

        for (int i = 2; i < arrayOfInts.length; i++) {
            int factor = arrayOfInts[i];
            int prod1 = factor * minProductOfTwoFactors;
            int prod2 = factor * maxProductOfTwoFactors;
            maxProduct = Math.max(
                    Math.max(prod1, prod2),
                    maxProduct);

            maxProductOfTwoFactors = Math.max(
                    Math.max(factor*maxFactor, factor*minFactor),
                    maxProductOfTwoFactors
            );
            minProductOfTwoFactors = Math.min(
                    Math.min(factor*minFactor, factor*maxFactor),
                    minProductOfTwoFactors
            );

            maxFactor = Math.max(maxFactor, factor);
            minFactor = Math.min(minFactor, factor);
        }

        return maxProduct;
    }


// [ 10, 10, 20, 30, 2 ]

// [ −10, −10, 1, 3, 2 ]

// [ −10, 5, 3, -6, 2 ]

}
