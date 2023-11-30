package example.springsecurity.service;

import example.springsecurity.dto.JwtRequest;
import example.springsecurity.dto.JwtResponse;
import example.springsecurity.dto.RegistrationUserDto;
import example.springsecurity.dto.UserDto;
import example.springsecurity.exceptions.RegistrationException;
import example.springsecurity.model.User;
import example.springsecurity.utils.JwtTokenUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;

/**
 * AuthService
 *
 * @author Grigory Dyakonov
 */

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthService {
    final UserDetailsServiceImpl userDetailsServiceImpl;
    final JwtTokenUtils jwtTokenUtils;
    final AuthenticationManager authenticationManager;

    public ResponseEntity<?> createToken(@RequestBody JwtRequest authRequest) throws BadCredentialsException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(), authRequest.getPassword()));
        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    public ResponseEntity<?> createUser(@RequestBody RegistrationUserDto registrationUserDto)
            throws SQLException, RegistrationException {
        if (!registrationUserDto.getPassword().equals(registrationUserDto.getConfirmPassword())) {
            throw new RegistrationException("Passwords do not match");
        }
        if (userDetailsServiceImpl.findByUsername(registrationUserDto.getUsername()).isPresent()) {
            throw new SQLException("User already exists");
        }
        User user = userDetailsServiceImpl.createNewUser(registrationUserDto);
        return ResponseEntity.ok(new UserDto(user.getId(), user.getUsername(), user.getEmail()));
    }
}
