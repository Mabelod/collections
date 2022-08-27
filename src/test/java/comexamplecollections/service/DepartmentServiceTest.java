package comexamplecollections.service;

import comexamplecollections.domain.Employee;
import comexamplecollections.example.EmployeeNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService departmentService;

    @BeforeEach
    public void beforeEach(){
        List<Employee> employees = List.of(
                new Employee("Иван", "Иванов",2,100000),
                new Employee("Семенов", "Андрей",2, 34000),
                new Employee("Николаев", "Игорь", 5, 58000),
                new Employee("Никитина", "Анна", 5, 97000),
                new Employee("Тодорашко", "Валерия", 5, 64000),
                new Employee("Пименова", "Ксения",5, 88000)
        );
        when(employeeService.conclusion()).thenReturn (employees);
    }

    @ParameterizedTest
    @MethodSource("employeeWithMaxSalaryParams")
    public void findMaxSalaryPositiveTest(Integer departmentStaff, Employee expected) {
        assertThat(departmentService.findMaxSalary(departmentStaff)).isEqualTo(expected);
    }

    @Test
    void findMaxSalaryNegativeTest() {
        assertThatExceptionOfType(EmployeeNotFound.class)
                .isThrownBy(() -> departmentService.findMaxSalary(8));
    }

    @ParameterizedTest
    @MethodSource("employeeWithMinSalaryParams")
    public void findMinSalaryPositiveTest(Integer departmentStaff, Employee expected) {
        assertThat(departmentService.findMinSalary(departmentStaff)).isEqualTo(expected);
    }

    @Test
    void findMinSalaryNegativeTest() {
        assertThatExceptionOfType(EmployeeNotFound.class)
                .isThrownBy(() -> departmentService.findMinSalary(8));
    }

    @ParameterizedTest
    @MethodSource("employeeAllDepartmentsParams")
    public void allDepartmentsPositiveTest(Integer departmentStaff, List<Employee> expected) {
        assertThat(departmentService.allDepartments(departmentStaff)).containsExactlyElementsOf(expected);
    }

    @Test
    void allDepartmentsNegativeTest() {
        assertThat(departmentService.allDepartments(8).isEmpty()); // ожидаю пустой список
    }

    public static Stream<Arguments> employeeWithMaxSalaryParams() {
        return Stream.of(
                Arguments.of(2, new Employee("Иван", "Иванов",2,100000)),
                Arguments.of(5, new Employee("Никитина", "Анна", 5, 97000))
        );
    }

    public static Stream<Arguments> employeeWithMinSalaryParams() {
        return Stream.of(
                Arguments.of(5, new Employee("Николаев", "Игорь", 5, 58000)),
                Arguments.of(2, new Employee("Семенов", "Андрей",2, 34000))
        );
    }

    public static Stream<Arguments> employeeAllDepartmentsParams() {
        return Stream.of(
                Arguments.of(5, List.of(new Employee("Николаев", "Игорь", 5, 58000),
                        new Employee("Никитина", "Анна", 5, 97000),
                        new Employee("Тодорашко", "Валерия", 5, 64000),
                        new Employee("Пименова", "Ксения", 5, 88000))),
                Arguments.of(2, List.of(new Employee("Иван", "Иванов", 2, 100000),
                        new Employee("Семенов", "Андрей", 2, 34000))),
                Arguments.of(8, Collections.emptyList()) // ожидаю от 8-го департамента пустой список , работает аналогично методу allDepartmentsNegativeTest
        );
    }
}