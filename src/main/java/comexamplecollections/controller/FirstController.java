package comexamplecollections.controller;

import comexamplecollections.domain.Employee;
import comexamplecollections.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/employees")
public class FirstController {
    private final EmployeeService employeeService;

    public FirstController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/find")
    public Employee findEmployees(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        return employeeService.findEmployees(firstName, lastName);
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String firstName,
                      @RequestParam("lastName") String lastName) {
            employeeService.addEmployees(firstName,lastName);
            return employeeService.findEmployees(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {
            employeeService.removeEmployees(firstName, lastName);
            return employeeService.findEmployees(firstName, lastName);
    }
    @GetMapping("conclusion")
    public Map<String ,Employee> conclusion() {
        return employeeService.conclusion();
    }
}
