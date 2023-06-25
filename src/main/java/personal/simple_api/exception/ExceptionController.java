package personal.simple_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import personal.simple_api.controller.PersonController;
import personal.simple_api.dto.ErrorResult;
import personal.simple_api.entity.Person;

@RestControllerAdvice(basePackageClasses = PersonController.class)
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ErrorResult handleErrorResult(Exception e) {
        return new ErrorResult(Boolean.FALSE, "에러데스");      // 이거 가능
        //return new ResponseEntity<>(new ErrorResult(Boolean.FALSE, "에러데스"), HttpStatus.BAD_REQUEST); 이것도 가능
    }

}
