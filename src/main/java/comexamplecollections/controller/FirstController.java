package comexamplecollections.controller;

import comexamplecollections.domain.Employee;
import comexamplecollections.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class FirstController {
    private final EmployeeService employeeService;

    public FirstController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public Employee getEmployees(@RequestParam("id") Integer id) {
        final Employee employees;
            employees = employeeService.getEmployees(id);
        return employees;
    }

    @GetMapping("/add")
    public String add(@RequestParam("firstName") String firstName,
                      @RequestParam("lastName") String lastName) {
        final Integer id = employeeService.id() + 1;
        final Employee employee = new Employee(
                firstName,
                lastName);
            employeeService.addEmployees(id ,employee);
        return "Сотрудник добавлен";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("id") Integer id) {
            employeeService.removeEmployees(id);
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
    public Map<Integer ,Employee> conclusion() {
        return employeeService.conclusion();
    }
}
