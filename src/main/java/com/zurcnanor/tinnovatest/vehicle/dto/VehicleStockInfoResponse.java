package com.zurcnanor.tinnovatest.vehicle.dto;

import com.zurcnanor.tinnovatest.interfaces.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
@Builder
public class VehicleStockInfoResponse extends Response {

    private Integer availableVehicleToSale;

    private Map<Integer, Integer> vehicleAmountByDecade;

    private Map<String, Integer> vehicleAmountByBrand;

}
