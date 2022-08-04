package comexamplecollections.service;

import comexamplecollections.domain.Employee;
import comexamplecollections.example.EmployeeNotFound;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class DepartmentService {
    private final EmployeeService employeeService;
    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee findMaxSalary(Integer departmentsId) {
        return employeeService.employees.values().stream().filter(e -> e.getDepartmentStaff() == departmentsId)
                .max(Comparator.comparingDouble(Employee -> Employee.getSalary())).orElseThrow(() -> new EmployeeNotFound());
    }

    public Employee findMinSalary(Integer departmentsId) {
        return employeeService.employees.values().stream().filter(e -> e.getDepartmentStaff() == departmentsId)
                .min(Comparator.comparingDouble(Employee -> Employee.getSalary())).orElseThrow(() -> new EmployeeNotFound());
    }

    public List<Employee> allDepartments(Integer departmentsId) {
        return employeeService.employees.values().stream().filter(e -> e.getDepartmentStaff() == departmentsId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> all() {
        return employeeService.employees.values().stream()
                .collect(Collectors.groupingBy(e -> e.getDepartmentStaff()));
    }
}
