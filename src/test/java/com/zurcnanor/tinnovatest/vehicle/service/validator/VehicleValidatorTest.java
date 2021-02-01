package com.zurcnanor.tinnovatest.vehicle.service.validator;

import com.zurcnanor.tinnovatest.brand.domain.Brand;
import com.zurcnanor.tinnovatest.brand.exception.BrandNotFoundException;
import com.zurcnanor.tinnovatest.brand.service.BrandService;
import com.zurcnanor.tinnovatest.vehicle.domain.Vehicle;
import com.zurcnanor.tinnovatest.vehicle.exception.InvalidBrandForVehicleException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class VehicleValidatorTest {

    private static final String BRAND_NAME = "Chevrolet";
    private static final String INVALID_BRAND_NAME = "Xevrolet";

    @Mock
    private BrandService brandService;

    @InjectMocks
    private VehicleValidator validator;

    @Before
    public void setUp() {
        when(brandService.getByName(BRAND_NAME))
                .thenReturn(Brand.builder().name(BRAND_NAME).build());

        when(brandService.getByName(INVALID_BRAND_NAME))
                .thenThrow(BrandNotFoundException.class);
    }

    @Test
    public void shouldValidateVehicle() {
        validator.validate(Vehicle.builder().brand(BRAND_NAME).build());

        verify(brandService).getByName(BRAND_NAME);
    }

    @Test(expected = InvalidBrandForVehicleException.class)
    public void shouldNotValidateVehicleWhenBrandIsInvalid() {
        validator.validate(Vehicle.builder().brand(INVALID_BRAND_NAME).build());

        verify(brandService).getByName(INVALID_BRAND_NAME);
    }

}
