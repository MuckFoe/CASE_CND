package de.thi.casemaster.cnd.event.adapter.api.rest.dto;

import de.thi.casemaster.cnd.event.domain.model.CalenderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEventRequest {
    private String name;
    private String description;
    private String startTime;
    private String endTime;
    private String place;
    private String calenderName;

}
