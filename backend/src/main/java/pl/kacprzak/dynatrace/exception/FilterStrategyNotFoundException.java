package pl.kacprzak.dynatrace.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Strategy is not found")
public class FilterStrategyNotFoundException extends IOException {

}
