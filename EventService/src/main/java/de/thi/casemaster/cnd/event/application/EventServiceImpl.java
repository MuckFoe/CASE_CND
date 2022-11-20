package de.thi.casemaster.cnd.event.application;

import de.thi.casemaster.cnd.event.adapter.api.rest.EventController;
import de.thi.casemaster.cnd.event.domain.EventService;
import de.thi.casemaster.cnd.event.domain.model.CalenderType;
import de.thi.casemaster.cnd.event.domain.model.Event;
import de.thi.casemaster.cnd.event.ports.outgoing.CalenderTypeRepository;
import de.thi.casemaster.cnd.event.ports.outgoing.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CalenderTypeRepository calenderTypeRepository;

    @Override
    public Event insert(String name, String description, LocalDateTime startTime, LocalDateTime endTime, String place, String calenderName) {
        Event event = new Event();
        event.setName(name);
        event.setDescription(description);
        event.setStartTime(startTime);
        event.setEndTime(endTime);
        event.setPlace(place);
        event.setCalenderName(calenderName);
        CalenderType calenderType = this.checkAndCreateCalenderTypeForEvent(calenderName);
        eventRepository.insert(event);
        return event;
    }


    @Override
    public Event findEvent(UUID id) {
        return eventRepository.findById(id.toString());
    }

    @Override
    public List<Event> getEventsToday() {
        return eventRepository.getTodaysEvents();
    }

    @Override
    public CalenderType checkAndCreateCalenderTypeForEvent(String name) {
        CalenderType calenderType = calenderTypeRepository.findByName(name);
        if (calenderType == null) {
            CalenderType creationCalenderType = new CalenderType();
            creationCalenderType.setName(name);
            creationCalenderType.setHexColor(getRandomHexColor());
            calenderTypeRepository.insert(creationCalenderType);
            return creationCalenderType;
        } else {
            return calenderType;
        }
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.getAllEvents();
    }


    public String getRandomHexColor() {
        Random obj = new Random();
        int rand_num = obj.nextInt(0xffffff + 1);
        return String.format("#%06x", rand_num);
    }
}
