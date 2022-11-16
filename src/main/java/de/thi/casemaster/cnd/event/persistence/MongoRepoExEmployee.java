package de.thi.casemaster.cnd.event.persistence;

import de.thi.casemaster.cnd.event.domain.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepoExEmployee extends MongoRepository<Employee, String> {
}
