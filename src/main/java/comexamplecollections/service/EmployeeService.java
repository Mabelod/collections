package comexamplecollections.service;

import comexamplecollections.domain.Employee;
import comexamplecollections.example.EmployeeAlreadyAdded;
import comexamplecollections.example.EmployeeInvalidToken;
import comexamplecollections.example.EmployeeNotFound;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

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
    public void removeEmployees(String firstName ,String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFound();
        }
        employees.remove(key);
    }
    public void addEmployees(String firstName ,String lastName) {
        Employee employee = new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName));
        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAdded();
        } else if (StringUtils.containsAny(key, '1', '2', '3', '4', '5', '6', '7', '8' ,'9' ,'0')) {
            throw new EmployeeInvalidToken();
        }
        employees.put(key ,employee);
    }
    private String getKey(String firstName, String lastName) {
        return StringUtils.capitalize(firstName) + " " + StringUtils.capitalize(lastName);
    }
}
