package de.thi.casemaster.cnd.event.persistence;

import de.thi.casemaster.cnd.event.domain.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class MongoDbEventRepository implements EventRepository {

    @Autowired
    MongoRepoExEvent mongoRepository;

    @Override
    public Event add(Event event) {
        return mongoRepository.insert(event);
    }

    @Override
    public Optional<Event> findById(String id) {
        return mongoRepository.findById(id);
    }
}
