package com.zurcnanor.tinnovatest.brand.mapper;

import com.zurcnanor.tinnovatest.brand.domain.Brand;
import com.zurcnanor.tinnovatest.brand.dto.BrandRequest;
import com.zurcnanor.tinnovatest.interfaces.IMapper;
import org.springframework.stereotype.Component;

@Component
public class BrandRequestMapper implements IMapper<BrandRequest, Brand> {

    @Override
    public Brand map(BrandRequest request) {
        if (null == request)
            return null;

        return Brand.builder()
                .name(request.getName())
                .build();
    }

}
