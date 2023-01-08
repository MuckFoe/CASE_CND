package de.thi.casemaster.cnd.event.adapter.api.rest;

import de.thi.casemaster.cnd.event.adapter.api.rest.dto.CreateEventResponse;
import de.thi.casemaster.cnd.event.domain.model.Event;
import de.thi.casemaster.cnd.event.domain.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;
    Logger logger = LoggerFactory.getLogger(EventController.class);

    @PostMapping
    public CreateEventResponse createEvent(@RequestBody Event event) {
        logger.info(LocalDateTime.now().toString());
        return eventService.insert(event.getName(), event.getDescription(), event.getStartTime(), event.getEndTime(), event.getPlace(), event.getCalenderName()).toEventResponse();
    }

    @GetMapping("/{eventId}")
    public CreateEventResponse findEvent(@PathVariable String eventId) {
        Event event = eventService.findEvent(UUID.fromString(eventId));
        return event.toEventResponse();
    }

    @GetMapping("/today")
    public List<CreateEventResponse> findEventsByStartTime() {
        List<Event> list = eventService.getEventsToday();
        return createEventResponseList(list);
    }

    @GetMapping
    public List<CreateEventResponse> findAllEvents() {
        List<Event> list = eventService.findAll();
        return createEventResponseList(list);
    }

    private List<CreateEventResponse> createEventResponseList(List<Event> inputEvents) {
        List<CreateEventResponse> outputEventList = new ArrayList<>();
        for (Event event : inputEvents) {
            outputEventList.add(event.toEventResponse());
        }
        return outputEventList;
    }
}



