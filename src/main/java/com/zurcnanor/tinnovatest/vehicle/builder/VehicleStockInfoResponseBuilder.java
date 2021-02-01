package com.zurcnanor.tinnovatest.vehicle.builder;

import com.zurcnanor.tinnovatest.vehicle.domain.Vehicle;
import com.zurcnanor.tinnovatest.vehicle.dto.VehicleStockInfoResponse;

import java.util.HashMap;
import java.util.List;

public class VehicleStockInfoResponseBuilder {

    private List<Vehicle> vehicles;

    public VehicleStockInfoResponseBuilder(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public VehicleStockInfoResponse build() {
        VehicleStockInfoResponse infoResponse = VehicleStockInfoResponse.builder()
                .availableVehicleToSale(0)
                .vehicleAmountByBrand(new HashMap<>())
                .vehicleAmountByDecade(new HashMap<>())
                .build();

        vehicles.forEach(vehicle -> {
            if (vehicle.getSold() == false)
                infoResponse.setAvailableVehicleToSale(infoResponse.getAvailableVehicleToSale().intValue() + 1);

            Integer vehicleAmountByBrand = infoResponse.getVehicleAmountByBrand().get(vehicle.getBrand().toUpperCase());
            if (null == vehicleAmountByBrand)
                infoResponse.getVehicleAmountByBrand().put(vehicle.getBrand().toUpperCase(), 1);
            else
                infoResponse.getVehicleAmountByBrand().put(vehicle.getBrand().toUpperCase(), vehicleAmountByBrand + 1);

            Integer vehicleDecade = (vehicle.getYear() / 10) * 10;
            Integer vehicleAmountByDecade = infoResponse.getVehicleAmountByDecade().get(vehicleDecade);
            if (null == vehicleAmountByDecade)
                infoResponse.getVehicleAmountByDecade().put(vehicleDecade, 1);
            else
                infoResponse.getVehicleAmountByDecade().put(vehicleDecade, vehicleAmountByDecade + 1);

        });

        return infoResponse;
    }

}
