package example.springsecurity.exceptions;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

/**
 * AppError
 *
 * @author Grigory Dyakonov
 */

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppError {
    int status;
    String message;
    Date timestamp;

    public AppError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
