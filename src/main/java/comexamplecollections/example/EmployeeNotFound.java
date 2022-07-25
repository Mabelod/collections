package comexamplecollections.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound() {
        super();
    }
}
