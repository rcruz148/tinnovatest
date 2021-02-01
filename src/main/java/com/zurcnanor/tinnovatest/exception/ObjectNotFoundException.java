package com.zurcnanor.tinnovatest.exception;

import lombok.Getter;

/**
 * Abstract class for exceptions of 'object not found' on application
 */
@Getter
public class ObjectNotFoundException extends BusinessException {

    public ObjectNotFoundException(String entityName) {
        super(entityName + ".not.found", "The " + entityName + " is not found.");
    }

}
