package de.thi.casemaster.cnd.event.domain.model;

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
}
