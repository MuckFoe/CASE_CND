package de.thi.casemaster.cnd.event.adapter.api.rest;

import de.thi.casemaster.cnd.event.adapter.api.rest.dto.EventResponse;
import de.thi.casemaster.cnd.event.domain.model.Event;
import de.thi.casemaster.cnd.event.domain.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;


    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.insert(event.getName(), event.getDescription(), event.getStartTime(), event.getEndTime(), event.getPlace(), event.getCalenderName());
    }

    @GetMapping("/{eventId}")
    public EventResponse findEvent(@PathVariable String eventId) {
        Event event = eventService.findEvent(UUID.fromString(eventId));
        return new EventResponse(event.getId(),
                event.getName(),
                event.getDescription(),
                event.getEndTime(),
                event.getStartTime(),
                event.getPlace(),
                event.getCalenderName());
    }

    @GetMapping("/today")
    public List<EventResponse> findEventsByStartTime() {
        List<Event> list = eventService.getEventsToday();
        return createEventResponseList(list);
    }

    @GetMapping
    public List<EventResponse> findAllEvents() {
        List<Event> list = eventService.findAll();
        return createEventResponseList(list);
    }

    private List<EventResponse> createEventResponseList(List<Event> inputEvents) {
        List<EventResponse> outputEventList = new ArrayList<>();
        for (Event event : inputEvents) {
            outputEventList.add(new EventResponse(event.getId(),
                    event.getName(),
                    event.getDescription(),
                    event.getEndTime(),
                    event.getStartTime(),
                    event.getPlace(),
                    event.getCalenderName()));
        }
        return outputEventList;
    }
}



