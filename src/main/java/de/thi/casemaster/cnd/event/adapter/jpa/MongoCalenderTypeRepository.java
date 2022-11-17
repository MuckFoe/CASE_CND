package de.thi.casemaster.cnd.event.adapter.jpa;

import de.thi.casemaster.cnd.event.adapter.jpa.entities.CalenderTypeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface MongoCalenderTypeRepository extends MongoRepository<CalenderTypeEntity, String> {
    Optional<CalenderTypeEntity> findByName(String name);

    Optional<CalenderTypeEntity> findByColor(String hexColor);

    Optional<String> getCalenderColor(UUID id);
}
