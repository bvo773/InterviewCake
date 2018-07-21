package com.lee.section01;

import static java.lang.Integer.MAX_VALUE;

public class Problem04 {
    int[] mergeArrays(int[] arrayA, int[] arrayB)
    {
        int[] result = new int[arrayA.length + arrayB.length];

        int a = 0;
        int b = 0;
        for (int r=0; r<result.length; r++)
        {
            int valA = Integer.MAX_VALUE;
            int valB = Integer.MAX_VALUE;

            if (a < arrayA.length) valA = arrayA[a];
            if (b < arrayB.length) valB = arrayB[b];

            if (valA < valB)
            {
                result[r] = valA;
                a++;
            }
            else
            {
                result[r] = valB;
                b++;
            }
        }

        return result;
    }
}

// int[] arrayA = new int[]{2, 4, 6, 10, 11, 15};
// int[] arrayB = new int[]{1, 5, 8, 12, 14, 19};

// int[] result = new int[] {1, 2, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19};
