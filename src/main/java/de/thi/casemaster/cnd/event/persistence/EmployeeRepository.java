package de.thi.casemaster.cnd.event.persistence;

import de.thi.casemaster.cnd.event.domain.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository {
    Employee add(Employee employee);

    Optional<Employee> findById(String id);

}
