package comexamplecollections.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyAdded extends RuntimeException {
    public EmployeeAlreadyAdded() {
        super();
    }
}
