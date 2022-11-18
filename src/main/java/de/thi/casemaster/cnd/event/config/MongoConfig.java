package de.thi.casemaster.cnd.event.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "de.thi.casemaster.cnd.event.adapter.jpa")
public class MongoConfig {

}