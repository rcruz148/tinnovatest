package com.zurcnanor.tinnovatest.brand.dto;

import com.zurcnanor.tinnovatest.interfaces.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class BrandResponse extends Response {

    private UUID id;

    private String name;

    private LocalDateTime createdAt;

}
