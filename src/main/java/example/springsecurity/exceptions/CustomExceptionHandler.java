package example.springsecurity.exceptions;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * CustomExceptionHandler
 *
 * @author Grigory Dyakonov
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(BaseExceptionHandler.class)
public @interface CustomExceptionHandler {
}
