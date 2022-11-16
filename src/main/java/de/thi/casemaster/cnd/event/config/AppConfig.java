package de.thi.casemaster.cnd.event.config;

import de.thi.casemaster.cnd.event.domain.services.EmployeeService;
import de.thi.casemaster.cnd.event.domain.services.EmployeeServiceImpl;
import de.thi.casemaster.cnd.event.domain.services.EventService;
import de.thi.casemaster.cnd.event.domain.services.EventServiceImpl;
import de.thi.casemaster.cnd.event.persistence.EmployeeRepository;
import de.thi.casemaster.cnd.event.persistence.EventRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public EmployeeService getEmployeeService(EmployeeRepository employeeRepository) {
        return new EmployeeServiceImpl(employeeRepository);
    }

    @Bean
    public EventService getEventService(EventRepository eventRepository) {
        return new EventServiceImpl(eventRepository);
    }
}
