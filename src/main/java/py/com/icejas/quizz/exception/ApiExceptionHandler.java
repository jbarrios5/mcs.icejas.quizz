package py.com.icejas.quizz.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;
@ControllerAdvice
public class ApiExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ApiExceptionHandler.class);
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiException(ApiRequestException e){
         ApiException apiException = new ApiException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );
        return  new ResponseEntity<>(apiException,HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception e){
        log.error(e.getMessage());
        ApiException apiException = new ApiException(
                "Unexpected error",
                HttpStatus.INTERNAL_SERVER_ERROR,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
