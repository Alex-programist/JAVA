package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void sum() {
        int[] arr = new int[]{-22, 34, 12, -4, 0};
        assertEquals(46,Task2.sum(arr,arr.length));
    }
}