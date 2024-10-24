package sa.bupa.sadirbootstrap.iam.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundByPrincipalException extends RuntimeException{
    public UserNotFoundByPrincipalException(String message) {
        super(message);
    }
}
