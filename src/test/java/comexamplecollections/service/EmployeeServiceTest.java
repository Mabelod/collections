package comexamplecollections.service;

import comexamplecollections.domain.Employee;
import comexamplecollections.example.EmployeeAlreadyAdded;
import comexamplecollections.example.EmployeeNotFound;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeService(new ValidatorService());

    @ParameterizedTest
    @MethodSource("params")
    void addEmployees(String firstName ,String lastName ) {
        Employee expected = new Employee(firstName, lastName);
        assertThat(employeeService.addEmployees(firstName, lastName))
                .isEqualTo(expected);

        assertThatExceptionOfType(EmployeeAlreadyAdded.class)
                .isThrownBy(() -> employeeService.addEmployees(firstName, lastName));
    }

    @ParameterizedTest
    @MethodSource("params")
    void removeNegativeEmployees(String firstName ,String lastName) {
        assertThatExceptionOfType(EmployeeNotFound.class)
                .isThrownBy(() -> employeeService.removeEmployees(Constants.firstName, Constants.lastName));

        Employee expected = new Employee(firstName, lastName);
        assertThat(employeeService.addEmployees(firstName, lastName)).isEqualTo(expected);
        assertThatExceptionOfType(EmployeeNotFound.class)
                .isThrownBy(() -> employeeService.removeEmployees(Constants.firstName, Constants.lastName));
    }

    @ParameterizedTest
    @MethodSource("params")
    void removePositiveEmployees(String firstName ,String lastName) {
        Employee expected = new Employee(firstName, lastName);
        assertThat(employeeService.addEmployees(firstName, lastName)).isEqualTo(expected);
        assertThat(employeeService.removeEmployees(firstName, lastName)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("params")
    void findNegativeEmployees(String firstName ,String lastName) {
        assertThatExceptionOfType(EmployeeNotFound.class)
                .isThrownBy(() -> employeeService.findEmployees(Constants.firstName, Constants.lastName));

        Employee expected = new Employee(firstName, lastName);
        assertThat(employeeService.addEmployees(firstName, lastName)).isEqualTo(expected);
        assertThatExceptionOfType(EmployeeNotFound.class)
                .isThrownBy(() -> employeeService.findEmployees(Constants.firstName, Constants.lastName));
    }

    @ParameterizedTest
    @MethodSource("params")
    void findPositiveEmployees(String firstName ,String lastName) {
        Employee expected = new Employee(firstName, lastName);
        assertThat(employeeService.addEmployees(firstName, lastName)).isEqualTo(expected);
        assertThat(employeeService.findEmployees(firstName, lastName)).isEqualTo(expected);
    }


    public static Stream<Arguments> params(){
        return Stream.of(
                Arguments.of("Антонов", "Игорь"),
                Arguments.of("Пилявский", "Павел"),
                Arguments.of("Минеева", "Зинаида")
        );
    }

}