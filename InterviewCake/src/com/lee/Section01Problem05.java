package com.lee;

public class Section01Problem05 {

    public static boolean IsSingleRuffle(int[] shuffledDeck, int[] half1, int[] half2)
    {
        int[] h1;
        int[] h2;

        if (shuffledDeck[0] == half1[0]) {
            h1 = half1;
            h2 = half2;
        }
        else {
            h1 = half2;
            h2 = half1;
        }

        int j = 0;
        for (int i =0; i < h1.length; i++, j+=2) {
            if (h1[i] == shuffledDeck[j] && h2[i] == shuffledDeck[j+1]) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static void Test_true()
    {
        int[] half1 = new int[] { 10, 24, 36, 7 };
        int[] half2 = new int[] { 15, 37, 51, 11 };
        int[] shuffledDeck =  new int[] { 10, 15, 24, 37, 36, 51, 7, 11 };

        System.out.println(IsSingleRuffle(shuffledDeck, half1, half2));
    }

    public static void Test_false()
    {
        int[] half1 = new int[] { 10, 24, 36, 7 };
        int[] half2 = new int[] { 15, 37, 51, 11 };
        int[] shuffledDeck =  new int[] { 10, 15, 51, 7, 24, 11, 37, 36 };

        System.out.println(IsSingleRuffle(shuffledDeck, half1, half2));
    }

    public static void Test_false_alternate()
    {
        int[] half1 = new int[] { 10, 24, 36, 7 };
        int[] half2 = new int[] { 15, 37, 51, 11 };
        int[] shuffledDeck =  new int[] { 10, 15, 37, 24, 36, 51, 7, 11 };

        System.out.println(IsSingleRuffle(shuffledDeck, half1, half2));
    }
}

/*
1 thru 52

half2        = { 15, 37, 51, 11 }
shuffledDeck = { 10, 15, 24, 37, 36, 51, 7, 11 } // true
half1        = { 10, 24, 36, 7 }
shuffledDeck = { 10, 15, 51, 7, 24, 11, 37, 36 } // false
 */
