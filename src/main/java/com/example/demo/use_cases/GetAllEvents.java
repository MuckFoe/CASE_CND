package com.example.demo.use_cases;

import com.example.demo.domain.Event;
import com.example.demo.domain.EventRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GetAllEvents {
    private final EventRepository eventRepository;

    public GetAllEvents(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAll() {
        return this.eventRepository.findAll();
    }
}
