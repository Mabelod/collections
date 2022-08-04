package comexamplecollections.service;

import comexamplecollections.domain.Employee;
import comexamplecollections.example.EmployeeAlreadyAdded;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {

    final public Map<String,Employee> employees = new HashMap<>(Map.of(
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
    public Map<String, Employee> conclusion() {
        return employees;
    }
    public Employee findEmployees(String firstName ,String lastName) {
        final Employee employee;
        String key = getKey(firstName, lastName);
        if (employees.containsKey(key) == false) {
            throw new EmployeeAlreadyAdded();
        }
        employee = employees.get(key);
        return employee;
    }
    public void removeEmployees(String firstName ,String lastName) {
        String key = getKey(firstName, lastName);
        if (employees.containsKey(key) == false) {
            throw new EmployeeAlreadyAdded();
        }
        employees.remove(key);
    }
    public void addEmployees(String firstName ,String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String key = getKey(firstName, lastName);
        if (employees.containsKey(key) == true) {
            throw new EmployeeAlreadyAdded();
        }
        employees.put(key ,employee);
    }
    private String getKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}
