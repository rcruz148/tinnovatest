package com.zurcnanor.tinnovatest.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Abstract class for application business exceptions
 */
@Getter
@AllArgsConstructor
public abstract class BusinessException extends RuntimeException {

    private String key;

    private String message;

}
