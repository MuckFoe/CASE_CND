package de.thi.casemaster.cnd.event.adapter.jpa.entities;

import de.thi.casemaster.cnd.event.domain.model.CalenderType;
import de.thi.casemaster.cnd.event.domain.model.Event;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
public class EventEntity {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String place;
    private String calenderName;

    public EventEntity() {
    }

    public Event toEvent() {
        return new Event(
                UUID.fromString(this.getId()),
                this.getName(),
                this.getDescription(),
                this.getStartTime(),
                this.getEndTime(),
                this.getPlace(),
                this.getCalenderName());
    }
}