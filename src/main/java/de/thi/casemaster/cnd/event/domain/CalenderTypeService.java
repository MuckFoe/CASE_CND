package de.thi.casemaster.cnd.event.domain;

import de.thi.casemaster.cnd.event.domain.model.CalenderType;

public interface CalenderTypeService {

    CalenderType createCalenderType(String name, String hexColor);

    CalenderType findCalenderType(String name);

    CalenderType getCalenderByColor(String hexColor);

}
