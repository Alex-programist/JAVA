package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void medium() {
        float[] arr = new float[]{-22, 34, 12, -4, 0};
        assertEquals(6.0,Task3.medium(arr));
    }
}