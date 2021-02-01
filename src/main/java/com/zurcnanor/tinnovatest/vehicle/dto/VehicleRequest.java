package com.zurcnanor.tinnovatest.vehicle.dto;

import com.zurcnanor.tinnovatest.interfaces.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleRequest extends Request implements Serializable {

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    @Size(max = 20)
    private String brand;

    @NotNull
    @Min(1800)
    private Integer year;

    @Size(max = 100)
    private String description;

    @NotNull
    private Boolean sold;

}
