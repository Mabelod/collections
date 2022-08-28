package comexamplecollections.service;

import comexamplecollections.domain.Employee;
import comexamplecollections.example.InvalidNameException;
import comexamplecollections.example.InvalidSurnameException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService {
    public Employee validateEmployee(String firstName ,
                                     String lastName){
        if (!StringUtils.isAlpha(firstName)) {
            throw new InvalidNameException();
        }
        if (!StringUtils.isAlpha(lastName)) {
            throw new InvalidSurnameException();
        }
        return new Employee(
                StringUtils.capitalize(firstName.toLowerCase()),
                StringUtils.capitalize(lastName.toLowerCase())
        );
    }

}
