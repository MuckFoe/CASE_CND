package de.thi.casemaster.cnd.event.domain;

import de.thi.casemaster.cnd.event.domain.model.CalenderType;
import de.thi.casemaster.cnd.event.domain.model.Event;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface EventService {

    Event insert(String name, String description, LocalDateTime startTime, LocalDateTime endTime, String place, String calenderName);

    Event findEvent(UUID id);

    List<Event> getEventsToday();

    CalenderType checkAndCreateCalenderTypeForEvent(String name);

    List<Event> findAll();

}
