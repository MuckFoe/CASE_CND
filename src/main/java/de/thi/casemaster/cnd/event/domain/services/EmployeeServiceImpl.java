package de.thi.casemaster.cnd.event.domain.services;

import de.thi.casemaster.cnd.event.domain.model.Employee;
import de.thi.casemaster.cnd.event.persistence.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.add(employee);
    }

    @Override
    public Employee getEmployee(String employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if (employee.isPresent()) {
            return employee.get();
        } else {
            // throw
        }
        return null;
    }
}
