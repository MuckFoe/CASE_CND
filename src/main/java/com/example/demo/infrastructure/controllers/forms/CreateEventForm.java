package com.example.demo.infrastructure.controllers.forms;

import com.example.demo.domain.Event;
import lombok.Getter;
import lombok.Setter;

public class CreateEventForm {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;


    public Event toEvent() {
        return new Event(this.name, this.description);
    }

}
