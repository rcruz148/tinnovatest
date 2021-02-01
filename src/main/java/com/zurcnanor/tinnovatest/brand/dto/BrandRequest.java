package com.zurcnanor.tinnovatest.brand.dto;

import com.zurcnanor.tinnovatest.interfaces.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandRequest extends Request {

    @NotBlank
    @Size(max = 20)
    private String name;

}
