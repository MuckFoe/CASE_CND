package de.thi.casemaster.cnd.event.domain.services;

import de.thi.casemaster.cnd.event.domain.model.Event;
import de.thi.casemaster.cnd.event.persistence.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event addEvent(Event event) {
        return eventRepository.add(event);
    }

    @Override
    public Event getEvent(String eventId) {
        Optional<Event> event = eventRepository.findById(eventId);

        if (event.isPresent()) {
            return event.get();
        } else {
            // throw
        }
        return null;
    }
}
