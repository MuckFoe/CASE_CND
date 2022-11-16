package de.thi.casemaster.cnd.event.controller;

import de.thi.casemaster.cnd.event.domain.model.Event;
import de.thi.casemaster.cnd.event.domain.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping(path = "/{eventId}")
    public Event getEvent(@PathVariable("eventId") String eventId) {
        return eventService.getEvent(eventId);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Event createEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }
}



