package com.zurcnanor.tinnovatest.vehicle.exception;

import com.zurcnanor.tinnovatest.exception.ObjectNotFoundException;

public class VehicleNotFoundException extends ObjectNotFoundException {

    public VehicleNotFoundException() {
        super("vehicle");
    }

}
