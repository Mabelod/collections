package comexamplecollections.controller;

import comexamplecollections.domain.Employee;
import comexamplecollections.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam("departmentId") Integer departmentsId) {
        return departmentService.findMaxSalary(departmentsId);
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam("departmentId") Integer departmentsId) {
        return departmentService.findMinSalary(departmentsId);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> allDepartments(@RequestParam("departmentId") Integer departmentsId) {
        return departmentService.allDepartments(departmentsId);
    }

    @GetMapping("/all")
    public Map<Integer,List<Employee>> all() {
        return departmentService.all();
    }
}
