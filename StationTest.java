package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {

    @Test
    void min() {
        List<Station> stations2 = new ArrayList<>();
        Station a1 = new Station(23,22,"322",3);
        Station a2 = new Station(22,34,"3",34);
        Station a3 = new Station(21,21,"35555",12);
        Station a4 = new Station(234,23,"33",322);
        stations2.add(a1);
        stations2.add(a2);
        stations2.add(a3);
        stations2.add(a4);
        assertEquals(3,Station.Min(stations2));
    }
}

