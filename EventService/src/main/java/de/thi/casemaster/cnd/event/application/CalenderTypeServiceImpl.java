package de.thi.casemaster.cnd.event.application;

import de.thi.casemaster.cnd.event.adapter.api.rest.dto.CalenderTypeResponse;
import de.thi.casemaster.cnd.event.domain.CalenderTypeService;
import de.thi.casemaster.cnd.event.domain.model.CalenderType;
import de.thi.casemaster.cnd.event.ports.outgoing.CalenderTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalenderTypeServiceImpl implements CalenderTypeService {

    @Autowired
    private CalenderTypeRepository calenderTypeRepository;

    @Override
    public CalenderTypeResponse createCalenderType(String name, String hexColor) {
        CalenderType existingCalenderType = calenderTypeRepository.findByName(name);
        if (existingCalenderType == null) {
            CalenderType newCalenderType = new CalenderType();
            newCalenderType.setHexColor(hexColor);
            newCalenderType.setName(name);
            calenderTypeRepository.insert(newCalenderType);
            return newCalenderType.toCalenderTypeResponse();
        } else {
            return existingCalenderType.toCalenderTypeResponse();
        }
    }

    @Override
    public CalenderTypeResponse findCalenderTypeByName(String name) {
        return calenderTypeRepository.findByName(name).toCalenderTypeResponse();
    }

    @Override
    public CalenderTypeResponse findCalenderTypeById(String Id) {
        return calenderTypeRepository.findById(Id).toCalenderTypeResponse();
    }

    @Override
    public List<CalenderType> findAll() {
        return calenderTypeRepository.getAllCalenderTypes();
    }

    @Override
    public CalenderTypeResponse findCalenderTypeByColor(String hexColor) {
        return calenderTypeRepository.findByColor(hexColor).toCalenderTypeResponse();
    }
}
