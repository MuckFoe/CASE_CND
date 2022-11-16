package de.thi.casemaster.cnd.event.persistence;

import de.thi.casemaster.cnd.event.domain.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MongoDbEmployeeRepository implements EmployeeRepository {

    @Autowired
    MongoRepoExEmployee mongoRepository;

    @Override
    public Employee add(Employee employee) {
        return mongoRepository.insert(employee);
    }

    @Override
    public Optional<Employee> findById(String id) {
        return mongoRepository.findById(id);
    }
}
