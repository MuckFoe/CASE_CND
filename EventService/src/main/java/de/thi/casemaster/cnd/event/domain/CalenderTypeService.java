package de.thi.casemaster.cnd.event.domain;

import de.thi.casemaster.cnd.event.adapter.api.rest.dto.CalenderTypeResponse;
import de.thi.casemaster.cnd.event.domain.model.CalenderType;

import java.util.List;

public interface CalenderTypeService {

    CalenderTypeResponse createCalenderType(String name, String hexColor);

    CalenderTypeResponse findCalenderTypeByName(String name);

    CalenderTypeResponse findCalenderTypeById(String Id);

    List<CalenderType> findAll();

    CalenderTypeResponse findCalenderTypeByColor(String calenderColor);
}
