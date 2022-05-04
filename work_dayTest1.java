package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class work_dayTest1 {

    @Test
    void avg() {
        List<work_day> work_days = new ArrayList<>();
        work_day a1 = new work_day("agera","fEWFW","3 1 2022",22,3);
        work_day a2 = new work_day("22t","WRHH","15 4 2022",34,10);
        work_day a3 = new work_day("ger","rwhrh","10 3 2022",7,1);
        work_day a4 = new work_day("gerge","WRHRH","22 2 2022",5,1);
        work_days.add(a1);
        work_days.add(a2);
        work_days.add(a3);
        work_days.add(a4);
        assertEquals(227,work_day.Avg(work_days));
    }
}