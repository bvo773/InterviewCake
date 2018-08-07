package com.lee.section04;

public class Problem02 {
    int FindDuplicate(int[] array) {
        int leftFloor = 1;                     // 1
        int leftCeiling = array.length / 2;    // n/2
        int rightFloor = array.length / 2 + 1; // n/2 + 1
        int rightCeiling = array.length - 1;   // n

        while (true) {
            int leftCount = 0;
            for (int i : array) {
                if (i <= leftCeiling) leftCount++;
            }
            int leftDistinct = leftCeiling - leftFloor + 1;
            if (leftCount > leftDistinct) {
                if (leftFloor == leftCeiling) return leftFloor;
                rightCeiling = leftCeiling;
                leftCeiling = leftFloor + leftCeiling / 2;
                rightFloor = leftFloor + leftCeiling / 2 + 1;
            }
            else {
                if (rightFloor == rightCeiling) return rightFloor;
                leftFloor = rightFloor;
                leftCeiling = rightFloor + rightCeiling / 2 - 1;
                rightFloor = rightFloor + rightCeiling / 2;
            }
            if (leftFloor == leftCeiling && rightFloor == rightCeiling)
                break;
        }

        return 0;
    }
}

// integers 1 2 3 4 5 6
//    array 1 2 3 4 5 6 4 (1 .. 6) = 6
// ------------------------------------------------------------------------------------
//     left 1 2 3         (1 .. 3) = 3
//    right 4 5 6 4       (4 .. 6) = 3 * this half contains the dup
// ------------------------------------------------------------------------------------
//       => left  4 4     (4)      = 1 ** this half contains the dup => 4 is the dup
//       => right 5 6     (5 .. 6) = 2

// PIGEONHOLE PRINCIPLE