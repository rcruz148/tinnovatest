package com.zurcnanor.tinnovatest.vehicle.service.validator;

import com.zurcnanor.tinnovatest.brand.exception.BrandNotFoundException;
import com.zurcnanor.tinnovatest.brand.service.BrandService;
import com.zurcnanor.tinnovatest.vehicle.domain.Vehicle;
import com.zurcnanor.tinnovatest.vehicle.exception.InvalidBrandForVehicleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleValidator {

    @Autowired
    private BrandService brandService;

    public void validate(Vehicle vehicle) {
        validateBrand(vehicle.getBrand());
    }

    private void validateBrand(String brandName) {
        try {
            brandService.getByName(brandName);
        } catch (BrandNotFoundException notFoundException) {
            throw new InvalidBrandForVehicleException();
        }
    }

}
