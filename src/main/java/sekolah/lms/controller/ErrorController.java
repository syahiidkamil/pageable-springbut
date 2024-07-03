package sekolah.lms.controller;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sekolah.lms.utils.Res;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e) {
        return Res.renderJson(null, e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<?> handleUnexpectedType(UnexpectedTypeException e) {
        String message = e.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (e.getMessage().contains("birthDate")) {
            message = "birthDate cannot be blank";
        }
        return Res.renderJson(null,message, status);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRunTime(RuntimeException e) {
        String message = e.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (e.getMessage().contains("student with id")) {
            message = "student not found";
        }
        return Res.renderJson(null, message, HttpStatus.BAD_REQUEST);
    }
}
