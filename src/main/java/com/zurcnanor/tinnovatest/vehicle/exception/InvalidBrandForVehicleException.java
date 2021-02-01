package com.zurcnanor.tinnovatest.vehicle.exception;

import com.zurcnanor.tinnovatest.exception.BusinessException;

public class InvalidBrandForVehicleException extends BusinessException {

    public InvalidBrandForVehicleException() {
        super("vehicle.branch.invalid", "Brand is invalid for vehicle.");
    }

}
