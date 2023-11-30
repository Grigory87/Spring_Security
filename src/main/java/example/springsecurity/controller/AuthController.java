package example.springsecurity.controller;

import example.springsecurity.dto.JwtRequest;
import example.springsecurity.dto.RegistrationUserDto;
import example.springsecurity.exceptions.CustomExceptionHandler;
import example.springsecurity.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * AuthController
 *
 * @author Grigory Dyakonov
 */

@RestController
@CustomExceptionHandler
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthController {
    final AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<?> createToken(@RequestBody JwtRequest authRequest) {
        return authService.createToken(authRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody RegistrationUserDto registrationUserDto) throws SQLException {
        return authService.createUser(registrationUserDto);
    }
}
