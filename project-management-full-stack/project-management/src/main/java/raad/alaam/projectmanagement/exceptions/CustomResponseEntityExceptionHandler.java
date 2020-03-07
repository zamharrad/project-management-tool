package raad.alaam.projectmanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handelPojectIdException (ProjectIdException ex ,WebRequest request){

        ProjectIdExceptionResponce exceptionResponce = new ProjectIdExceptionResponce(ex.getMessage());
        return new ResponseEntity(exceptionResponce, HttpStatus.CREATED);
    }
}
