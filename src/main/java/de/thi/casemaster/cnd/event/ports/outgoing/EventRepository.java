package de.thi.casemaster.cnd.event.ports.outgoing;

import de.thi.casemaster.cnd.event.domain.model.Event;

import java.util.List;

public interface EventRepository {
    void insert(Event event);

    Event findById(String id);

    List<Event> getTodaysEvents();

    List<Event> getAllEvents();
}
