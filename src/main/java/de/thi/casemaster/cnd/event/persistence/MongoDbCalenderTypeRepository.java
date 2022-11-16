package de.thi.casemaster.cnd.event.persistence;

import de.thi.casemaster.cnd.event.domain.model.CalenderType;
import de.thi.casemaster.cnd.event.domain.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MongoDbCalenderTypeRepository implements CalenderTypeRepository {

    @Autowired
    MongoRepoExCalenderType mongoRepository;

    @Override
    public CalenderType addCalenderType(CalenderType calenderType) {
        return mongoRepository.insert(calenderType);
    }

    @Override
    public Optional<CalenderType> findById(String id) {
        return mongoRepository.findById(id);
    }
}
