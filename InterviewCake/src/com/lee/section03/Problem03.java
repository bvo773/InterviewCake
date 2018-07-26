package com.lee.section03;

public class Problem03 {
    // input:
    // [1, 7, 3, 4]
    //
    // output:
    // [7 * 3 * 4,  1 * 3 * 4,  1 * 7 * 4,  1 * 7 * 3]
    // [       84,         12,         28,         21]

    // input array
    // [1, 2, 6, 5, 9]

    int[] getProductsOfAllIntsExceptAtIndex(int[] input) {
        int[] result = new int[input.length];

        // fill the result array with the product of all the factors on the left of the current index
        int product = 1;
        for (int i = 0; i < input.length; i++) {
            result[i] = product;
            product = product * input[i];
        }

        // update result array with the product of all the factors on the right of the current index
        product = 1;
        for (int i = input.length-1; i >= 0; i--) {
            result[i] = result[i] * product;
            product = product * input[i];
        }

        return result;
    }

    int[] getProductsOfAllIntsExceptAtIndex_BRUTE_FORCE(int[] input) {
        int[] result = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            int product = 1;
            for (int j = 0; j < input.length; j++) {
                if (j == i) continue;
                product = product * input[j];
            }
            result[i] = product;
        }

        return result;
    }
}
