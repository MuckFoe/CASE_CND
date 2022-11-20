package de.thi.casemaster.cnd.event.domain.model;

import de.thi.casemaster.cnd.event.adapter.api.rest.dto.CalenderTypeResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CalenderType {
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    private String hexColor;

    public CalenderType() {
        this.id = UUID.randomUUID();
    }

    public CalenderTypeResponse toCalenderTypeResponse() {
        CalenderTypeResponse calenderTypeResponse = new CalenderTypeResponse();
        calenderTypeResponse.setName(this.name);
        calenderTypeResponse.setHexColor(this.hexColor);
        calenderTypeResponse.setId(this.id);
        return calenderTypeResponse;
    }
}
