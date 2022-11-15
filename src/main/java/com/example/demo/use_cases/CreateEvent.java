package com.example.demo.use_cases;

import com.example.demo.domain.Event;
import com.example.demo.domain.EventRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CreateEvent {

    private final EventRepository eventRepository;

    public CreateEvent(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event create(Event event) {
        return this.eventRepository.save(event);
    }
}
