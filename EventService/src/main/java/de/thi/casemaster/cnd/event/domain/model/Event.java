package de.thi.casemaster.cnd.event.domain.model;

import de.thi.casemaster.cnd.event.adapter.api.rest.dto.CreateEventResponse;
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

    public CreateEventResponse toEventResponse() {
        CreateEventResponse createEventResponse = new CreateEventResponse();
        createEventResponse.setName(this.name);
        createEventResponse.setDescription(this.description);
        createEventResponse.setCalenderName(this.calenderName);
        createEventResponse.setEndTime(this.endTime);
        createEventResponse.setStartTime(this.startTime);
        createEventResponse.setPlace(this.place);
        createEventResponse.setId(this.id);
        createEventResponse.setCalenderName(this.calenderName);
        return createEventResponse;
    }

}
