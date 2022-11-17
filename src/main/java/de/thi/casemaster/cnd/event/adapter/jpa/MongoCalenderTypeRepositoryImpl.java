package de.thi.casemaster.cnd.event.adapter.jpa;

import de.thi.casemaster.cnd.event.adapter.jpa.entities.CalenderTypeEntity;
import de.thi.casemaster.cnd.event.domain.model.CalenderType;
import de.thi.casemaster.cnd.event.ports.outgoing.CalenderTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MongoCalenderTypeRepositoryImpl implements CalenderTypeRepository {

    @Autowired
    MongoCalenderTypeRepository mongoRepository;

    @Override
    public void insert(CalenderType calenderType) {
        CalenderTypeEntity ct = new CalenderTypeEntity();
        ct.setName(calenderType.getName());
        ct.setHexColor(calenderType.getHexColor());
        ct.setId(calenderType.getId().toString());
        mongoRepository.save(ct);
    }

    @Override
    public CalenderType findById(String id) {
        Optional<CalenderTypeEntity> calenderTypeEntity = mongoRepository.findById(id.toString());
        if (calenderTypeEntity.isPresent()) {
            return calenderTypeEntity.get().toCalenderType();
        }
        return null;
    }

    @Override
    public CalenderType findByName(String name) {
        Optional<CalenderTypeEntity> calenderTypeEntity = mongoRepository.findByName(name);
        if (calenderTypeEntity.isPresent()) {
            return calenderTypeEntity.get().toCalenderType();
        }
        return null;
    }

    @Override
    public CalenderType findByColor(String hexColor) {
        Optional<CalenderTypeEntity> calenderTypeEntity = mongoRepository.findByColor(hexColor);
        if (calenderTypeEntity.isPresent()) {
            return calenderTypeEntity.get().toCalenderType();
        }
        return null;
    }

    @Override
    public String getCalenderColor(UUID id) {
        Optional<CalenderTypeEntity> calenderTypeEntity = mongoRepository.findById(id.toString());
        if (calenderTypeEntity.isPresent()) {
            return calenderTypeEntity.get().toCalenderType().getHexColor();
        }
        return null;
    }
}
