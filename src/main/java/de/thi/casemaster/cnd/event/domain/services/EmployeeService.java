package de.thi.casemaster.cnd.event.domain.services;

import de.thi.casemaster.cnd.event.domain.model.Employee;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    Employee getEmployee(String employeeId);
}
