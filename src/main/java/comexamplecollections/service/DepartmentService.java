package comexamplecollections.service;

import comexamplecollections.domain.Employee;
import comexamplecollections.example.EmployeeNotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    final private List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Иван", "Иванов",5,100000),
            new Employee("Семенов", "Андрей",1, 34000),
            new Employee("Николаев", "Игорь", 4, 58000),
            new Employee("Никитина", "Анна", 3, 97000),
            new Employee("Тодорашко", "Валерия", 5, 64000),
            new Employee("Пименова", "Ксения",1, 88000),
            new Employee("Смирнов", "Дмитрий",3, 64000),
            new Employee("Пальчиков", "Александр",2, 53000),
            new Employee("Ушакова", "Нина",3, 45000),
            new Employee("Щербакова", "Анастасия",5, 950000)
    ));

    public Employee findMaxSalary(Integer departmentsId) {
        return employees.stream().filter(e -> e.getDepartmentStaff() == departmentsId)
                .max(Comparator.comparingDouble(Employee -> Employee.getSalary())).orElseThrow();
    }

    public Employee findMinSalary(Integer departmentsId) {
        return employees.stream().filter(e -> e.getDepartmentStaff() == departmentsId)
                .min(Comparator.comparingDouble(Employee -> Employee.getSalary())).orElseThrow();
    }

    public List<Employee> allDepartments(Integer departmentsId) {
        if (departmentsId <= 0 || departmentsId > 5) {
            throw new EmployeeNotFound();
        } else {
            return employees.stream().filter(e -> e.getDepartmentStaff() == departmentsId)
                    .collect(Collectors.toList());
        }
        }

    public List<Employee> all() {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee -> Employee.getDepartmentStaff()))
                .collect(Collectors.toList());
    }

}
