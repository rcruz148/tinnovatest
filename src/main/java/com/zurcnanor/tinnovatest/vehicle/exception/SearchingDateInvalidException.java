package com.zurcnanor.tinnovatest.vehicle.exception;

import com.zurcnanor.tinnovatest.exception.BusinessException;

public class SearchingDateInvalidException extends BusinessException {

    public SearchingDateInvalidException(String parsedString) {
        super("vehicle.searching.date.invalid", "The searching date is invalid: " + parsedString);
    }

}
