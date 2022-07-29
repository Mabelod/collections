package comexamplecollections.service;

import comexamplecollections.domain.Employee;
import comexamplecollections.example.EmployeeAlreadyAdded;
import comexamplecollections.example.EmployeeNotFound;
import comexamplecollections.example.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {

    final Map<Integer,Employee> employees = new HashMap<>(Map.of(
            1,
            new Employee("Иван", "Иванов"),
            2,
            new Employee("Семенов", "Андрей"),
            3,
            new Employee("Николаев", "Игорь"),
            4,
            new Employee("Никитина", "Анна"),
            5,
            new Employee("Тодорашко", "Валерия"),
            6,
            new Employee("Пименова", "Ксения")
    ));

    public Map<Integer, Employee> conclusion() {
        return employees;
    }

    public Employee getEmployees(Integer id) {
        final Employee employee;
        if (id > employees.size()) {
            throw new EmployeeStorageIsFullException();
        }
        employee = employees.get(id);
        return employee;
    }

    public void removeEmployees(int id) {
        if(id > employees.size()){
            throw new EmployeeStorageIsFullException();
        }
        employees.remove(id);
    }

    public void addEmployees(Integer id ,Employee employee) {
        if (employees.containsValue(employee) == true) {
            throw new EmployeeAlreadyAdded();
        }
        employees.put(id ,employee);
    }

    public void findEmployees(Employee employee) {
        if (employees.containsValue(employee) == false) {
            throw new EmployeeNotFound();
        }
    }
    public Integer id() {
        Integer id = employees.size();
        return id;
    }
}
