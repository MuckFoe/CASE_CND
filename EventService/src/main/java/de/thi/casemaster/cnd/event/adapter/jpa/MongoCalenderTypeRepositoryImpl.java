package de.thi.casemaster.cnd.event.adapter.jpa;

import de.thi.casemaster.cnd.event.adapter.api.rest.EventController;
import de.thi.casemaster.cnd.event.adapter.jpa.entities.CalenderTypeEntity;
import de.thi.casemaster.cnd.event.adapter.jpa.entities.EventEntity;
import de.thi.casemaster.cnd.event.domain.model.CalenderType;
import de.thi.casemaster.cnd.event.domain.model.Event;
import de.thi.casemaster.cnd.event.ports.outgoing.CalenderTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MongoCalenderTypeRepositoryImpl implements CalenderTypeRepository {

    Logger logger = LoggerFactory.getLogger(MongoCalenderTypeRepositoryImpl.class);

    @Autowired
    MongoCalenderTypeRepository mongoCalenderTypeRepository;

    @Override
    public void insert(CalenderType calenderType) {
        CalenderTypeEntity ct = new CalenderTypeEntity();
        ct.setCalenderName(calenderType.getName());
        ct.setHexColor(calenderType.getHexColor());
        ct.setId(calenderType.getId().toString());
        mongoCalenderTypeRepository.save(ct);
    }

    @Override
    public List<CalenderType> getAllCalenderTypes() {
        Iterable<CalenderTypeEntity> all = mongoCalenderTypeRepository.findAll();
        List<CalenderType> calenderTypes = new ArrayList<>();
        all.forEach(calenderTypeEntity -> calenderTypes.add(calenderTypeEntity.toCalenderType()));
        return calenderTypes;


    }

    @Override
    public CalenderType findById(String id) {
        Optional<CalenderTypeEntity> calenderTypeEntity = mongoCalenderTypeRepository.findById(id);
        if (calenderTypeEntity.isPresent()) {
            return calenderTypeEntity.get().toCalenderType();
        }
        return null;
    }

    @Override
    public CalenderType findByName(String name) {
        List<CalenderTypeEntity> calenderTypeEntityList = mongoCalenderTypeRepository.findByName(name);
        if (calenderTypeEntityList.isEmpty()) {
            return null;
        }
        return calenderTypeEntityList.get(0).toCalenderType();
    }

    @Override
    public CalenderType findByColor(String hexColor) {
        Optional<CalenderTypeEntity> calenderTypeEntity = mongoCalenderTypeRepository.findByColor(hexColor);
        if (calenderTypeEntity.isPresent()) {
            return calenderTypeEntity.get().toCalenderType();
        }
        return null;
    }
}
