package de.thi.casemaster.cnd.event.domain.services;

import de.thi.casemaster.cnd.event.domain.model.Event;

public interface EventService {

    Event addEvent(Event event);

    Event getEvent(String eventId);
}
