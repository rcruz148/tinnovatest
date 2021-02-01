package com.zurcnanor.tinnovatest.vehicle.mapper;

import com.zurcnanor.tinnovatest.interfaces.IMapper;
import com.zurcnanor.tinnovatest.vehicle.domain.Vehicle;
import com.zurcnanor.tinnovatest.vehicle.dto.VehicleRequest;
import org.springframework.stereotype.Component;

@Component
public class VehicleRequestMapper implements IMapper<VehicleRequest, Vehicle> {

    @Override
    public Vehicle map(VehicleRequest request) {
        if (null == request)
            return null;

        return Vehicle.builder()
                .name(request.getName())
                .brand(request.getBrand())
                .description(request.getDescription())
                .year(request.getYear())
                .sold(request.getSold())
                .build();
    }

}
