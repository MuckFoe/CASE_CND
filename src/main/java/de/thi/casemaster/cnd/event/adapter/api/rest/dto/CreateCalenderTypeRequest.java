package de.thi.casemaster.cnd.event.adapter.api.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCalenderTypeRequest {
    private String name;
    private String hexColor;
}

