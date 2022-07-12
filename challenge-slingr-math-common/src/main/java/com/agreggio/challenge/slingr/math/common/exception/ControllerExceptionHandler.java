package com.agreggio.challenge.slingr.math.common.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.script.ScriptException;
import java.nio.file.AccessDeniedException;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<ErrorResponse> handleItemNotAcceptableException(IllegalArgumentException exception) {
        log.error("The value is not acceptable", exception);
        return buildResponseError(HttpStatus.NOT_ACCEPTABLE, exception.getMessage());
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<ErrorResponse> handleItemNotAcceptableException(IllegalStateException exception) {
        log.error("The value is not acceptable", exception);
        return buildResponseError(HttpStatus.NOT_ACCEPTABLE, exception.getMessage());
    }

    @ExceptionHandler(JsonProcessingException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleJsonProcessingException(JsonProcessingException exception) {
        log.error("Error to convert json to object", exception);
        return buildResponseError(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }



    @ExceptionHandler(ScriptException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<ErrorResponse> handleAccessDeniedExceptions(ScriptException e) {
        log.error("An Error has occurred {}", e.getMessage());
        return buildResponseError(HttpStatus.NOT_ACCEPTABLE, "Error on expression position " + (e.getColumnNumber() - 4));
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ErrorResponse> handleAccessDeniedExceptions(Exception e) {
        log.error("An Error has occurred", e);
        return buildResponseError(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<ErrorResponse> handleUsernameNotFoundException(Exception e) {
        log.error("An Error has occurred {}", e.getMessage());
        return buildResponseError(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleExceptions(Exception e) {
        log.error("An Error has occurred", e);
        return buildResponseError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    private ResponseEntity<ErrorResponse> buildResponseError(HttpStatus status, String message) {
        ErrorResponse errorResponse = new ErrorResponse(status, message);
        return ResponseEntity.status(status).body(errorResponse);
    }
}
