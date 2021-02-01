package com.zurcnanor.tinnovatest.exception.dto;

import com.zurcnanor.tinnovatest.interfaces.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Representation class for application errors
 */
@Data
@AllArgsConstructor
@Builder
public class ErrorResponse extends Response implements Serializable {

    private int statusCode;

    private String key;

    private String message;

    private LocalDateTime timestamp;

}
