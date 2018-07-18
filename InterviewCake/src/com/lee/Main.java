package com.lee;

public class Main {

    public static void main(String[] args) {
        Section02Problem03 test = new Section02Problem03();
        test.displayHash(test.BuildWordCloud_buildOnString("After  beating the eggs, Dana read the next step:"));
        System.out.println();
        test.displayHash(test.BuildWordCloud_buildUsingIndex("After  beating the eggs, Dana read the next step:"));


    }
}
