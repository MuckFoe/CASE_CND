package de.thi.casemaster.cnd.event.domain.model;

import de.thi.casemaster.cnd.event.adapter.api.rest.dto.EventResponse;
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

    public EventResponse toEventResponse() {
        EventResponse eventResponse = new EventResponse();
        eventResponse.setName(this.name);
        eventResponse.setDescription(this.description);
        eventResponse.setCalenderName(this.calenderName);
        eventResponse.setEndTime(this.endTime);
        eventResponse.setStartTime(this.startTime);
        eventResponse.setPlace(this.place);
        eventResponse.setId(this.id);
        eventResponse.setCalenderName(this.calenderName);
        return eventResponse;
    }

}
