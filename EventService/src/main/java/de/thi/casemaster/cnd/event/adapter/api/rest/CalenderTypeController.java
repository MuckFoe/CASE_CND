package de.thi.casemaster.cnd.event.adapter.api.rest;

import de.thi.casemaster.cnd.event.adapter.api.rest.dto.CalenderTypeResponse;
import de.thi.casemaster.cnd.event.adapter.api.rest.dto.CreateCalenderTypeRequest;
import de.thi.casemaster.cnd.event.domain.CalenderTypeService;
import de.thi.casemaster.cnd.event.domain.model.CalenderType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/calendertype")
public class CalenderTypeController {

    Logger logger = LoggerFactory.getLogger(CalenderTypeController.class);

    @Autowired
    private CalenderTypeService calenderTypeService;

    @PostMapping
    public CalenderTypeResponse createEvent(@RequestBody CreateCalenderTypeRequest createCalenderTypeRequest) {
        return calenderTypeService.createCalenderType(createCalenderTypeRequest.getName(), createCalenderTypeRequest.getHexColor());
    }

    @GetMapping
    public List<CalenderTypeResponse> findAllCalenderTypes() {
        List<CalenderType> list = calenderTypeService.findAll();
        return createCalenderTypeResponseList(list);
    }

    @GetMapping("/id={calenderId}")
    public CalenderTypeResponse findCalenderTypeById(@PathVariable String calenderId) {
        CalenderTypeResponse calenderTypeResponse = calenderTypeService.findCalenderTypeById(calenderId);
        return calenderTypeResponse;
    }

    @GetMapping("/name={calenderId}")
    public CalenderTypeResponse findCalenderTypeByName(@PathVariable String calenderId) {
        CalenderTypeResponse calenderTypeResponse = calenderTypeService.findCalenderTypeByName(calenderId);
        return calenderTypeResponse;
    }

    @GetMapping("/color={calenderColor}")
    public CalenderTypeResponse findCalenderTypeByColor(@PathVariable String calenderColor) {
        CalenderTypeResponse calenderTypeResponse = calenderTypeService.findCalenderTypeByColor(calenderColor);
        return calenderTypeResponse;
    }

    private List<CalenderTypeResponse> createCalenderTypeResponseList(List<CalenderType> inputCalenderTypes) {
        List<CalenderTypeResponse> outputCalenderTypeResponseList = new ArrayList<>();
        for (CalenderType calenderType : inputCalenderTypes) {
            outputCalenderTypeResponseList.add(calenderType.toCalenderTypeResponse());
        }
        return outputCalenderTypeResponseList;
    }
}