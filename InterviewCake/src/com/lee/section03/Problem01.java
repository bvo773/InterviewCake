package com.lee.section03;

public class Problem01 {

    int getMaxProfit(int[] stockPrices) {

        int minPrice = Integer.MAX_VALUE;            // +100  15  7  5 5 5 5 4 4
        int maxProfit = Integer.MIN_VALUE;           // -100 -21 -8 -2 3 6 6 6 6

        for (int price : stockPrices) {              // 15 7 5 8 11 9 4
            int profit = price - minPrice;           // calculate profit at this price
            maxProfit = Math.max(profit, maxProfit); // update the maxProfit
            minPrice = Math.min(price, minPrice);    // update the minPrice
        }

        return maxProfit;
    }
}


// int[] stockPrices = new int[] {10, 7, 5, 4, 3, 1};
// int[] stockPrices = new int[] {15, 7, 5, 8, 11, 9, 4, 6};
