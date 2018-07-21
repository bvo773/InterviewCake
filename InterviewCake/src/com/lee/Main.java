package com.lee;

import com.lee.section02.Problem03;

public class Main {

    public static void main(String[] args) {
        Problem03 test = new Problem03();
        test.displayHash(test.BuildWordCloud_buildOnString("After  beating the eggs, Dana read the next step:"));
        System.out.println();
        test.displayHash(test.BuildWordCloud_buildUsingIndex("After  beating the eggs, Dana read the next step:"));
    }
}
