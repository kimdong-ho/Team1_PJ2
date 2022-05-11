package com.example.team1_pj2;

public class EventItem {
    int id;
    String title;
    String startDay;
    String endDay;
    String startTime;
    String endTime;

    public EventItem(int id, String title, String startDay, String endDay) {
        this.id = id;
        this.title = title;
        this.startDay = startDay;
        this.endDay = endDay;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public EventItem() {}

}
