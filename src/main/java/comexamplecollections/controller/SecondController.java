package comexamplecollections.controller;

import comexamplecollections.domain.Employee;
import comexamplecollections.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SecondController {
    private final DepartmentService departmentService;

    public SecondController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments/max-salary")
    public Employee maxSalary(@RequestParam("departmentId") Integer departmentsId) {
        return departmentService.findMaxSalary(departmentsId);
    }

    @GetMapping("/departments/min-salary")
    public Employee minSalary(@RequestParam("departmentId") Integer departmentsId) {
        return departmentService.findMinSalary(departmentsId);
    }

    @GetMapping("/departments/all")
    public List<Employee> allDepartments(@RequestParam("departmentId") Integer departmentsId) {
        return departmentService.allDepartments(departmentsId);
    }

    @GetMapping("/departments/list")
    public List<Employee> all() {
        return departmentService.all();
    }
}
