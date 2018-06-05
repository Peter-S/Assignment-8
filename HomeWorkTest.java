package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class HomeWorkTest {

    @Test
    public void main() {
        int[] data1 = {1, 18, 2, 7, 18, 39, 18, 40};

        ArrayIntList list1 = new ArrayIntList();
        for (int n : data1) {
            list1.add(n);
        }

        int[] data2 = {1, 18, 2, 7, 18, 39, 18, 40};

        ArrayIntList list2 = new ArrayIntList();
        for (int n : data2) {
            list2.add(n);
        }

        list2.replaceAll(18, 0);
        System.out.println("Beginning list:       " + list1);
        System.out.println("Replaced values list: " + list2);

        assertFalse(list1.toString().compareTo(list2.toString()) == 0);
        
        assertEquals("Beginning list, old values: ", 18, list1.get(1));
        assertEquals("Replaced list, new values: ", 0, list2.get(1));

        assertEquals("Beginning list, old values: ", 18, list1.get(4));
        assertEquals("Replaced list, new values: ", 0, list2.get(4));

        assertEquals("Beginning list, old values: ", 18, list1.get(6));
        assertEquals("Replaced list, new values: ", 0, list2.get(6));

    }
}