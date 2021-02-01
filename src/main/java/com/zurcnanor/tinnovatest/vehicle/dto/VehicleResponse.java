package com.zurcnanor.tinnovatest.vehicle.dto;

import com.zurcnanor.tinnovatest.interfaces.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class VehicleResponse extends Response implements Serializable {

    private UUID id;

    private String name;

    private String brand;

    private Integer year;

    private String description;

    private Boolean isSold;

    private LocalDateTime createdAt;

}
