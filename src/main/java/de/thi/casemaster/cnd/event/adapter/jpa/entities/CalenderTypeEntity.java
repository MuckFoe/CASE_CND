package de.thi.casemaster.cnd.event.adapter.jpa.entities;

import de.thi.casemaster.cnd.event.domain.model.CalenderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CalenderTypeEntity {
    @Id
    private String id;
    private String name;
    private String hexColor;


    public CalenderType toCalenderType() {
        return new CalenderType(UUID.fromString(this.getId()),
                this.getName(),
                this.getHexColor());
    }
}