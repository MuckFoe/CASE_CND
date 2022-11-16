package de.thi.casemaster.cnd.event.persistence;

import de.thi.casemaster.cnd.event.domain.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepoExEvent extends MongoRepository<Event, String> {
}
