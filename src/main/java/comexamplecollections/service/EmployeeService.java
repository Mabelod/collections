package comexamplecollections.service;

import comexamplecollections.domain.Employee;
import comexamplecollections.example.EmployeeAlreadyAdded;
import comexamplecollections.example.EmployeeNotFound;
import comexamplecollections.example.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Иван", "Иванов"),
            new Employee("Семенов", "Андрей"),
            new Employee("Николаев", "Игорь"),
            new Employee("Никитина", "Анна"),
            new Employee("Тодорашко", "Валерия"),
            new Employee("Пименова", "Ксения")
    ));

    public List<Employee> conclusion() {
        List<Employee> employee = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            employee.add(employees.get(i));
        }
        return employee;
    }

    public String getEmployees(Integer number) {
        final Employee employee;
        if (number >= employees.size()) {
            throw new EmployeeStorageIsFullException();
        }
        employee = employees.get(number);
        final String personEmployees = employee.getFirstName() + " " + employee.getLastName();
        return personEmployees;
    }

    public void removeEmployees(int number) {
        if(number >= employees.size()){
            throw new EmployeeStorageIsFullException();
        }
        employees.remove(number);
    }

    public void addEmployees(Employee employee) {
        if (employees.contains(employee) == true) {
            throw new EmployeeAlreadyAdded();
        }
        employees.add(employee);
    }

    public void findEmployees(Employee employee) {
        if (employees.contains(employee) == false) {
            throw new EmployeeNotFound();
        }
    }
}
