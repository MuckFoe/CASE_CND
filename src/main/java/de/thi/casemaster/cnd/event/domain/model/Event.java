package de.thi.casemaster.cnd.event.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Event {
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String place;
    private String calenderName;

    public Event() {
        this.id = UUID.randomUUID();
    }

}
