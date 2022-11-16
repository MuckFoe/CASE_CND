package de.thi.casemaster.cnd.event.config;

import de.thi.casemaster.cnd.event.persistence.MongoRepoExEmployee;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = MongoRepoExEmployee.class)
public class MongoConfig {
}
