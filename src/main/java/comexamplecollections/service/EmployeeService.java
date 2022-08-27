package comexamplecollections.service;

import comexamplecollections.domain.Employee;
import comexamplecollections.example.EmployeeAlreadyAdded;
import comexamplecollections.example.EmployeeNotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private final ValidatorService validatorService;

    final private Map<String,Employee> employees = new HashMap<>(Map.of(
            "Иван Иванов",
            new Employee("Иван", "Иванов",2,100000),
            "Семенов Андрей",
            new Employee("Семенов", "Андрей",1, 34000),
            "Николаев Игорь",
            new Employee("Николаев", "Игорь", 5, 58000),
            "Никитина Анна",
            new Employee("Никитина", "Анна", 5, 97000),
            "Тодорашко Валерия",
            new Employee("Тодорашко", "Валерия", 5, 64000),
            "Пименова Ксения",
            new Employee("Пименова", "Ксения",5, 88000)
    ));

    public EmployeeService(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    public List<Employee> conclusion() {
        return new ArrayList<>(employees.values());
    }
    public Employee findEmployees(String firstName ,String lastName) {
        final Employee employee;
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFound();
        }
        employee = employees.get(key);
        return employee;
    }
    public Employee removeEmployees(String firstName ,String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFound();
        }
        employees.remove(key);
        return employee;
    }
    public Employee addEmployees(String firstName ,String lastName) {
        Employee employee = validatorService.validateEmployee(firstName, lastName);
        String key = getKey(employee.getFirstName(), employee.getLastName());
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAdded();
        }
        employees.put(key ,employee);
        return employee;
    }
    private String getKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}
