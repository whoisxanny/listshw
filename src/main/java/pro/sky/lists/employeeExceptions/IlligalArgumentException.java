package pro.sky.lists.employeeExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IlligalArgumentException extends RuntimeException{
    public IlligalArgumentException() {
    }

    public IlligalArgumentException(String message) {
        super("Illigal arguments");
    }

    public IlligalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public IlligalArgumentException(Throwable cause) {
        super(cause);
    }

    public IlligalArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
