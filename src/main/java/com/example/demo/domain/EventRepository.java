package com.example.demo.domain;

import java.util.List;

public interface EventRepository {

    Event save(Event event);

    List<Event> findAll();
}
