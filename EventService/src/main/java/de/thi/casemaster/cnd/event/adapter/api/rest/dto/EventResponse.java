package de.thi.casemaster.cnd.event.adapter.api.rest.dto;

import de.thi.casemaster.cnd.event.domain.model.CalenderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventResponse {
    private UUID id;
    private String name;
    private String description;
    private LocalDateTime endTime;
    private LocalDateTime startTime;
    private String place;
    private String calenderName;
}
