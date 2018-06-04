package com.company;

import java.util.Random;

public class HomeWork {

    public static void main(String[] args) {

        int[] data1 = {1, 18, 2, 7, 18, 39, 18, 40};

        ArrayIntList list = new ArrayIntList();
        for (int n : data1) {
            list.add(n);
        }

        System.out.println("Testing: " + list);
        list.replaceAll(18, 236551);
        System.out.println("Results: " + list);
        System.out.println("I can't get this next one to work. It looks correct");
        System.out.println("New list for next problem ");
        System.out.println(list.lastIndxOf(236551));
        }
    }


