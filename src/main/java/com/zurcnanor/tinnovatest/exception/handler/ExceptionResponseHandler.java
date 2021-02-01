package com.zurcnanor.tinnovatest.exception.handler;

import com.zurcnanor.tinnovatest.exception.BusinessException;
import com.zurcnanor.tinnovatest.exception.ObjectNotFoundException;
import com.zurcnanor.tinnovatest.exception.dto.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static java.time.LocalDateTime.now;

@ControllerAdvice
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    protected ResponseEntity<Object> handleBusinessException(BusinessException exception, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .key(exception.getKey())
                .message(exception.getMessage())
                .timestamp(now())
                .build();

        return handleExceptionInternal(exception, errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = ObjectNotFoundException.class)
    protected ResponseEntity<Object> handleNotFound(ObjectNotFoundException exception, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .key(exception.getKey())
                .message(exception.getMessage())
                .timestamp(now())
                .build();

        return handleExceptionInternal(exception, errorResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}
