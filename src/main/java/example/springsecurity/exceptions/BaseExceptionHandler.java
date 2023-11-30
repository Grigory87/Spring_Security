package example.springsecurity.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * BaseExceptionHandler
 *
 * @author Grigory Dyakonov
 */

@RestControllerAdvice(annotations = CustomExceptionHandler.class)
public class BaseExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    protected ResponseEntity handleBadCredentialsException() {
        AppError appError = new AppError(HttpStatus.UNAUTHORIZED.value(), "Incorrect username or password");
        return new ResponseEntity<>(appError, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(SQLException.class)
    protected ResponseEntity handleSQLException(SQLException exception) {
        AppError appError = new AppError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
        return new ResponseEntity<>(appError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RegistrationException.class)
    protected ResponseEntity handleRegistrationException(RegistrationException exception) {
        AppError appError = new AppError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
        return new ResponseEntity<>(appError, HttpStatus.BAD_REQUEST);
    }
}
