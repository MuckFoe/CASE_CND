package de.thi.casemaster.cnd.event.ports.outgoing;

import de.thi.casemaster.cnd.event.domain.model.CalenderType;

import java.util.UUID;

public interface CalenderTypeRepository {
    void insert(CalenderType calenderType);

    CalenderType findById(String id);

    CalenderType findByName(String name);

    CalenderType findByColor(String hexColor);

    String getCalenderColor(UUID id);
}
