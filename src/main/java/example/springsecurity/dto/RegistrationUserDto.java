package example.springsecurity.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * RegistrationUserDto
 *
 * @author Grigory Dyakonov
 */

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegistrationUserDto {
    String username;
    String password;
    String confirmPassword;
    String email;
}
