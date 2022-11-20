package de.thi.casemaster.cnd.event.ports.outgoing;

import de.thi.casemaster.cnd.event.domain.model.CalenderType;

import java.util.List;
import java.util.UUID;

public interface CalenderTypeRepository {
    void insert(CalenderType calenderType);

    List<CalenderType> getAllCalenderTypes();

    CalenderType findById(String id);

    CalenderType findByName(String name);

    CalenderType findByColor(String hexColor);

}
