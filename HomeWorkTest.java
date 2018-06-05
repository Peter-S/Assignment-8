package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class HomeWorkTest {

    @Test
    public void main() {
//        create list1 - for use before before any changes - arraylist of integers
        int[] data1 = {1, 18, 2, 7, 18, 39, 18, 40};

        ArrayIntList list1 = new ArrayIntList();
        for (int n : data1) {
            list1.add(n);
        }
//        create list2 - list I can change and use for comparison - arraylist of integers
        int[] data2 = {1, 18, 2, 7, 18, 39, 18, 40};

        ArrayIntList list2 = new ArrayIntList();
        for (int n : data2) {
            list2.add(n);
        }

//        run replaceAll on list2 to use for comparison
        list2.replaceAll(18, 0);

//        pribts list1 and list2 - make sure replaceAll worked - old school test
        System.out.println("Beginning list:       " + list1);
        System.out.println("Replaced values list: " + list2);

//        j-unit test to verify some change happened to the lists
        assertFalse(list1.toString().compareTo(list2.toString()) == 0);

//        check list1 to see if old value is in the right place and
//          then check list2 to make sure the replaceAll worked
        assertEquals("Beginning list, old values: ", 18, list1.get(1));
        assertEquals("Replaced list, new values: ", 0, list2.get(1));

        assertEquals("Beginning list, old values: ", 18, list1.get(4));
        assertEquals("Replaced list, new values: ", 0, list2.get(4));

        assertEquals("Beginning list, old values: ", 18, list1.get(6));
        assertEquals("Replaced list, new values: ", 0, list2.get(6));

//        makes sure the Last Index Of method works
        assertEquals(6, list1.lastIndxOf(18));
        assertEquals(6, list2.lastIndxOf(0));

//        check one more number - double check my Last Index Of method
        assertEquals(7, list1.lastIndxOf(40));
        assertEquals(7, list2.lastIndxOf(40));
    }
}
