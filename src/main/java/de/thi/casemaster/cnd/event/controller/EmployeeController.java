package de.thi.casemaster.cnd.event.controller;

import de.thi.casemaster.cnd.event.domain.model.Employee;
import de.thi.casemaster.cnd.event.domain.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping(path = "/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") String employeeId) {
        return employeeService.getEmployee(employeeId);
    }
}
