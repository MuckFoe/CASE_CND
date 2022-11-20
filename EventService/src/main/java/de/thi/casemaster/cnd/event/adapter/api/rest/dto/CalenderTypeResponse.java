package de.thi.casemaster.cnd.event.adapter.api.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalenderTypeResponse {
    private UUID id;
    private String name;
    private String hexColor;
}
