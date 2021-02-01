package com.zurcnanor.tinnovatest.brand.mapper;

import com.zurcnanor.tinnovatest.brand.domain.Brand;
import com.zurcnanor.tinnovatest.brand.dto.BrandResponse;
import com.zurcnanor.tinnovatest.interfaces.IMapper;
import org.springframework.stereotype.Component;

@Component
public class BrandResponseMapper implements IMapper<Brand, BrandResponse> {

    @Override
    public BrandResponse map(Brand brand) {
        if (null == brand)
            return null;

        return BrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .createdAt(brand.getCreatedAt())
                .build();
    }

}
