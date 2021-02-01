package com.zurcnanor.tinnovatest.vehicle.mapper;

import com.zurcnanor.tinnovatest.interfaces.IMapper;
import com.zurcnanor.tinnovatest.vehicle.domain.Vehicle;
import com.zurcnanor.tinnovatest.vehicle.dto.VehicleResponse;
import org.springframework.stereotype.Component;

@Component
public class VehicleResponseMapper implements IMapper<Vehicle, VehicleResponse> {

    @Override
    public VehicleResponse map(Vehicle vehicle) {
        if (null == vehicle)
            return null;

        return VehicleResponse.builder()
                .id(vehicle.getId())
                .name(vehicle.getName())
                .brand(vehicle.getBrand())
                .description(vehicle.getDescription())
                .year(vehicle.getYear())
                .isSold(vehicle.getSold())
                .createdAt(vehicle.getCreatedAt())
                .build();
    }

}
