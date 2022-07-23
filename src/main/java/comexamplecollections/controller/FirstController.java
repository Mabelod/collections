package comexamplecollections.controller;

import comexamplecollections.domain.Employee;
import comexamplecollections.example.EmployeeAlreadyAdded;
import comexamplecollections.example.EmployeeNotFound;
import comexamplecollections.example.EmployeeStorageIsFullException;
import comexamplecollections.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class FirstController {
    private final EmployeeService employeeService;

    public FirstController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String getEmployees(@RequestParam("number") Integer number) {
        final String employees;
        try {
            employees = employeeService.getEmployees(number);
        } catch (EmployeeStorageIsFullException e) {
            return "Нет сотрудника под таким номером";
        }
        return employees;
    }

    @GetMapping("/add")
    public String add(@RequestParam("firstName") String firstName,
                      @RequestParam("lastName") String lastName) {
        final Employee employee = new Employee(
                firstName,
                lastName);
        try {
            employeeService.addEmployees(employee);
        } catch (EmployeeAlreadyAdded employeeAlreadyAdded) {
            return "Сотрудник уже добавлен";
        }
        return "Сотрудник добавлен";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("number") Integer number) {
        try {
            employeeService.removeEmployees(number);
        } catch (EmployeeStorageIsFullException e) {
            return "Нет сотрудника под таким номером";
        }
        return "Сотрудник удален";
    }

    @GetMapping("/find")
    public String find(@RequestParam("firstName") String firstName,
                      @RequestParam("lastName") String lastName) {
        final Employee employee = new Employee(
                firstName,
                lastName);
        try {
            employeeService.findEmployees(employee);
        } catch (EmployeeNotFound e) {
            return "Сотрудник не найден.";
        }
        return "Сотрудник найден = " + firstName + " " + lastName;
    }
    @GetMapping("conclusion")
    public List<Employee> conclusion() {
        return employeeService.conclusion();
    }
}
