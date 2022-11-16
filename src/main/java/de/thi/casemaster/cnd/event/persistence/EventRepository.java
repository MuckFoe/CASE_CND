package de.thi.casemaster.cnd.event.persistence;

import de.thi.casemaster.cnd.event.domain.model.Event;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository {
    Event add(Event event);

    Optional<Event> findById(String id);
}
