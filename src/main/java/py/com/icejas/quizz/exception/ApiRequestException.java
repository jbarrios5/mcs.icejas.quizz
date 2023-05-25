package py.com.icejas.quizz.exception;

import org.springframework.http.HttpStatus;

public class ApiRequestException extends  RuntimeException{
    private HttpStatus httpStatus;
    public ApiRequestException(String message,HttpStatus status) {
        super(message);
        this.httpStatus = status;
    }
    public ApiRequestException(String message) {
        super(message);
    }
    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }

}
