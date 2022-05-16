package com.example.demo3;

public class TimeTable {
    public int id;
    public String day;
    public int group;
    public int count;
    public int getId(){return id;}
    public String getDay(){return day;}
    public int getGroup(){return group;}
    public int getCount(){return count;}

    public TimeTable(int id,String day, int group, int count) {
        this.id = id;
        this.day = day;
        this.group = group;
        this.count = count;
    }
}

