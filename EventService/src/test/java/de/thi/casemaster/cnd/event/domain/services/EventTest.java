package de.thi.casemaster.cnd.event.domain.services;

import de.thi.casemaster.cnd.event.EventServiceApplication;
import de.thi.casemaster.cnd.event.adapter.api.rest.dto.CreateEventResponse;
import de.thi.casemaster.cnd.event.domain.model.Event;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = EventServiceApplication.class)
public class EventTest {

    @Test
    public void testConvertEvent() throws Exception {
        Event inputEvent = new Event();
        inputEvent.setPlace("test");
        CreateEventResponse eventResponse = inputEvent.toEventResponse();

        assertThat(inputEvent.getPlace()).isEqualTo(eventResponse.getPlace());
    }

}
