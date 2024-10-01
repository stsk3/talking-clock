package com.stsk.handler;

import com.stsk.dto.ClockDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = DateTimeParseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ClockDTO handleDateTimeParseException(final DateTimeParseException ex) {
        return new ClockDTO(ex.getParsedString(), "Your clock is malfunctioning!");
    }

}
