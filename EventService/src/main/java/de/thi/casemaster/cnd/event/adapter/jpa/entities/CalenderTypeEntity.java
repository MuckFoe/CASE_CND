package de.thi.casemaster.cnd.event.adapter.jpa.entities;

import de.thi.casemaster.cnd.event.domain.model.CalenderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "calenderType")
public class CalenderTypeEntity {
    @Id
    private String id;
    private String calenderName;
    private String hexColor;


    public CalenderType toCalenderType() {
        return new CalenderType(UUID.fromString(this.getId()),
                this.getCalenderName(),
                this.getHexColor());
    }
}