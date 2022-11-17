package de.thi.casemaster.cnd.event.config;

import de.thi.casemaster.cnd.event.adapter.jpa.MongoEventRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = MongoEventRepository.class)
public class MongoConfig {
}