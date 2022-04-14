package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    public void max() {
        int[] arr = new int[]{-22, 34, 12, -4, 0};
        assertEquals(34,Task1.max(arr));
    }
}