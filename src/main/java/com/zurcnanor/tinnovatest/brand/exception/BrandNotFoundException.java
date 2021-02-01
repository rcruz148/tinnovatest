package com.zurcnanor.tinnovatest.brand.exception;

import com.zurcnanor.tinnovatest.exception.ObjectNotFoundException;

public class BrandNotFoundException extends ObjectNotFoundException {

    public BrandNotFoundException() {
        super("brand");
    }

}
