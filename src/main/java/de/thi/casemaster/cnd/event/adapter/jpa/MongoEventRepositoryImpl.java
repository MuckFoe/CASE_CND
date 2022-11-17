package de.thi.casemaster.cnd.event.adapter.jpa;

import de.thi.casemaster.cnd.event.adapter.jpa.entities.EventEntity;
import de.thi.casemaster.cnd.event.domain.model.Event;
import de.thi.casemaster.cnd.event.ports.outgoing.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MongoEventRepositoryImpl implements EventRepository {

    @Autowired
    MongoEventRepository mongoRepository;

    @Override
    public void insert(Event event) {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setId(event.getId().toString());
        eventEntity.setName(event.getName());
        eventEntity.setDescription(event.getDescription());
        eventEntity.setEndTime(event.getEndTime());
        eventEntity.setStartTime(event.getStartTime());
        eventEntity.setCalenderName(event.getCalenderName());
        mongoRepository.save(eventEntity);

    }

    @Override
    public Event findById(String id) {
        Optional<EventEntity> eventEntity = mongoRepository.findById(id.toString());
        if (eventEntity.isPresent()) {
            return eventEntity.get().toEvent();
        }
        return null;
    }

    @Override
    public List<Event> getTodaysEvents() {
        int currentDay = LocalDateTime.now().getDayOfYear();
        List<EventEntity> all = mongoRepository.findAll();
        List<Event> events = new ArrayList<>();
        for (EventEntity eventEntity : all) {
            if (eventEntity.getStartTime().getDayOfYear() == currentDay) {
                events.add(eventEntity.toEvent());
            }
        }
        return events;
    }

    @Override
    public List<Event> getAllEvents() {
        List<EventEntity> all = mongoRepository.findAll();
        List<Event> events = new ArrayList<>();
        all.forEach(el -> events.add(el.toEvent()));
        return events;
    }
}
