package com.example.demo.infrastructure.controllers;

import com.example.demo.domain.Dummy;
import com.example.demo.domain.Event;
import com.example.demo.infrastructure.controllers.forms.CreateDummyDataForm;
import com.example.demo.infrastructure.controllers.forms.CreateEventForm;
import com.example.demo.use_cases.CreateEvent;
import com.example.demo.use_cases.GetAllEvents;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    private final CreateEvent createEvent;
    private final GetAllEvents getAllEvents;

    public EventController(CreateEvent createEvent, GetAllEvents getAllEvents) {
        this.createEvent = createEvent;
        this.getAllEvents = getAllEvents;
    }

    @GetMapping(value = "/api/event", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Event> getAllEvents() {
        return getAllEvents.getAll();
    }

    @PostMapping(value = "/api/event", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Event createEvent(@RequestBody CreateEventForm createEventForm) {
        return createEvent.create(createEventForm.toEvent());
    }
}

