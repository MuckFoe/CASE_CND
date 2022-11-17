package de.thi.casemaster.cnd.event.application;

import de.thi.casemaster.cnd.event.domain.CalenderTypeService;
import de.thi.casemaster.cnd.event.domain.model.CalenderType;
import de.thi.casemaster.cnd.event.ports.outgoing.CalenderTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CalenderTypeServiceImpl implements CalenderTypeService {

    @Autowired
    private CalenderTypeRepository calenderTypeRepository;

    @Override
    public CalenderType createCalenderType(String name, String hexColor) {
        CalenderType calenderType = new CalenderType();
        calenderType.setHexColor(hexColor);
        calenderType.setName(name);
        calenderTypeRepository.insert(calenderType);
        return calenderType;
    }

    @Override
    public CalenderType findCalenderType(String name) {
        return calenderTypeRepository.findByName(name);
    }

    @Override
    public CalenderType getCalenderByColor(String hexColor) {
        return calenderTypeRepository.findByColor(hexColor);
    }
}
