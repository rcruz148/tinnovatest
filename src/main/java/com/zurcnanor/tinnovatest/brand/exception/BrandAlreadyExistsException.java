package com.zurcnanor.tinnovatest.brand.exception;

import com.zurcnanor.tinnovatest.exception.BusinessException;

public class BrandAlreadyExistsException extends BusinessException {

    public BrandAlreadyExistsException() {
        super("branch.already.exists", "The brand already exists.");
    }

}
