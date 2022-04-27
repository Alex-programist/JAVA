package com.company;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StationTest2 {

    @Test
    void heig() throws IOException {
        List<Station> stations2 = new ArrayList<>();
        Station a1 = new Station(23,22,"322",3);
        Station a2 = new Station(22,34,"3",34);
        Station a3 = new Station(21,21,"35555",12);
        Station a4 = new Station(234,23,"33",322);
        Station a11 = new Station(a1);
        Station a22 = new Station(a2);
        Station a33 = new Station(a3);
        Station a43 = new Station(a4);
        assertEquals(5,Station.Heig());
    }
}