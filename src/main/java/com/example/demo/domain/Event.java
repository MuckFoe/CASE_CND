package com.example.demo.domain;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private long id;
    private String name;
    private String description;

    /*
    private Date startTime;
    private Date endTime;

    private String place;
    private CalenderType calenderType;
    */
    public Event(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
