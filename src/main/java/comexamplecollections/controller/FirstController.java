package comexamplecollections.controller;

import comexamplecollections.domain.Employee;
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
    public Employee getEmployees(@RequestParam("number") Integer number) {
        final Employee employees;
            employees = employeeService.getEmployees(number);
        return employees;
    }

    @GetMapping("/add")
    public String add(@RequestParam("firstName") String firstName,
                      @RequestParam("lastName") String lastName) {
        final Employee employee = new Employee(
                firstName,
                lastName);
            employeeService.addEmployees(employee);
        return "Сотрудник добавлен";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("number") Integer number) {
            employeeService.removeEmployees(number);
        return "Сотрудник удален";
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName,
                      @RequestParam("lastName") String lastName) {
        final Employee employee = new Employee(
                firstName,
                lastName);
            employeeService.findEmployees(employee);
        return employee;
    }
    @GetMapping("conclusion")
    public List<Employee> conclusion() {
        return employeeService.conclusion();
    }
}
