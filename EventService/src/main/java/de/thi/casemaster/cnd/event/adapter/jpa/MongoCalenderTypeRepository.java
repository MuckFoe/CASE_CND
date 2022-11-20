package de.thi.casemaster.cnd.event.adapter.jpa;

import de.thi.casemaster.cnd.event.adapter.jpa.entities.CalenderTypeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MongoCalenderTypeRepository extends MongoRepository<CalenderTypeEntity, String> {

    @Query("{ 'calenderName' : ?0 }")
    List<CalenderTypeEntity> findByName(String calenderName);

    @Query("{ 'hexColor' : ?0 }")
    Optional<CalenderTypeEntity> findByColor(String hexColor);

}
