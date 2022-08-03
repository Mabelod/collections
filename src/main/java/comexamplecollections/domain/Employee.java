package comexamplecollections.domain;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;

    private int departmentStaff;

    private int salary;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String firstName, String lastName, int departmentStaff, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentStaff = departmentStaff;
        this.salary = salary;

    }

    public int getDepartmentStaff() {
        return departmentStaff;
    }

    public void setDepartmentStaff(int departmentStaff) {
        this.departmentStaff = departmentStaff;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Имя='" + firstName + '\'' +
                ", Фамилия='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
