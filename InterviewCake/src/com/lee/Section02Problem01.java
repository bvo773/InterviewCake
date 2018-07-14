package com.lee;

import java.util.HashSet;

public class Section02Problem01 {
    boolean TwoMoviesEqualFlightLength(int flightLength, int[] movieLengths) {
        HashSet<Integer> complementSet = new HashSet<Integer>();

        for (int i = 0; i < movieLengths.length; i++) {
            if (complementSet.contains(movieLengths[i]))     // 140
                return true;
            int complement = flightLength - movieLengths[i];
            complementSet.add(complement);                   // 80, 70, 100, 140
        }
        return false;
    }
}

// flightLength = 200 minutes
// movieLengths = { 120, 130, 100, 60, 140 } // true
// movieLengths = { 120, 130, 100, 60, 150 } // false

//dictionary: key-value
//0 => 120
//1 => 130
//2 => 100
//
//
//hashset: key only
//internalArray = { 0 , 1 , 2, 3 , 4 }
