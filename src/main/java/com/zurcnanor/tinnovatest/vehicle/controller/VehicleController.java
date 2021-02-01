package com.zurcnanor.tinnovatest.vehicle.controller;

import com.zurcnanor.tinnovatest.interfaces.AbstractController;
import com.zurcnanor.tinnovatest.interfaces.IMapper;
import com.zurcnanor.tinnovatest.interfaces.IService;
import com.zurcnanor.tinnovatest.vehicle.builder.VehicleStockInfoResponseBuilder;
import com.zurcnanor.tinnovatest.vehicle.domain.Vehicle;
import com.zurcnanor.tinnovatest.vehicle.dto.SearchSpecification;
import com.zurcnanor.tinnovatest.vehicle.dto.VehicleRequest;
import com.zurcnanor.tinnovatest.vehicle.dto.VehicleResponse;
import com.zurcnanor.tinnovatest.vehicle.dto.VehicleStockInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("vehicles")
public class VehicleController extends AbstractController<Vehicle, UUID, VehicleRequest, VehicleResponse> {

    @Autowired
    public VehicleController(IService<Vehicle, UUID> service,
                             IMapper<VehicleRequest, Vehicle> requestMapper,
                             IMapper<Vehicle, VehicleResponse> responseMapper) {
        super(service, requestMapper, responseMapper);
    }

    @GetMapping("/stock-information")
    public ResponseEntity<VehicleStockInfoResponse> getStockInfo() {
        VehicleStockInfoResponseBuilder infoResponseBuilder = new VehicleStockInfoResponseBuilder(service.getAll(new SearchSpecification()));
        return ResponseEntity.ok().body(infoResponseBuilder.build());
    }

}
