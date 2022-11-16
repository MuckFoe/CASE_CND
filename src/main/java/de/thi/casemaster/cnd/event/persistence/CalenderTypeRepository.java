package de.thi.casemaster.cnd.event.persistence;

import de.thi.casemaster.cnd.event.domain.model.CalenderType;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CalenderTypeRepository {
    CalenderType addCalenderType(CalenderType calenderType);

    Optional<CalenderType> findById(String id);
}
