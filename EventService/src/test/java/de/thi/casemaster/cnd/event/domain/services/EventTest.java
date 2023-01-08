package de.thi.casemaster.cnd.event.domain.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.thi.casemaster.cnd.event.EventServiceApplication;
import de.thi.casemaster.cnd.event.adapter.api.rest.dto.CreateCalenderTypeRequest;
import de.thi.casemaster.cnd.event.adapter.api.rest.dto.CreateEventRequest;
import de.thi.casemaster.cnd.event.adapter.jpa.MongoCalenderTypeRepository;
import de.thi.casemaster.cnd.event.adapter.jpa.MongoEventRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = EventServiceApplication.class)
@AutoConfigureMockMvc
@AutoConfigureDataMongo
public class EventTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private MongoCalenderTypeRepository calenderTypeRepository;
    @Autowired
    MongoEventRepository eventRepository;

    @Before
    public void cleanUp() {
        calenderTypeRepository.deleteAll();
        eventRepository.deleteAll();
    }

    @Test
    public void testCreateEvent() throws Exception {
        CreateEventRequest eventRequest = new CreateEventRequest();
        eventRequest.setCalenderName("CalenderTestName");
        eventRequest.setDescription("empty");
        eventRequest.setEndTime(LocalDateTime.now().plusHours(1).toString());
        eventRequest.setStartTime(LocalDateTime.now().minusHours(1).toString());
        eventRequest.setPlace("testplace");
        mvc.perform(post("/events")
                        .content(asJsonString(eventRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.description").value("empty"))
                .andExpect(jsonPath("$.place").value("testplace"))
                .andReturn();

    }

    @Test
    public void testCreateCalenderType() throws Exception {
        CreateCalenderTypeRequest calenderTypeRequest = new CreateCalenderTypeRequest();
        calenderTypeRequest.setName("testType");
        mvc.perform(post("/api/calendertype")
                        .content(asJsonString(calenderTypeRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("testType"))
                .andReturn();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <D> D fromJsonString(final String data, final Class<D> clazz) {
        try {
            return new ObjectMapper().readValue(data, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
