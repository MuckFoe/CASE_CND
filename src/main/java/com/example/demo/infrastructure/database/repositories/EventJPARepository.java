package com.example.demo.infrastructure.database.repositories;

import com.example.demo.domain.Event;
import com.example.demo.domain.EventRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventJPARepository extends JpaRepository<Event, Long>, EventRepository {
}
