package com.zurcnanor.tinnovatest.brand.controller;

import com.zurcnanor.tinnovatest.brand.domain.Brand;
import com.zurcnanor.tinnovatest.brand.dto.BrandRequest;
import com.zurcnanor.tinnovatest.brand.dto.BrandResponse;
import com.zurcnanor.tinnovatest.interfaces.AbstractController;
import com.zurcnanor.tinnovatest.interfaces.IMapper;
import com.zurcnanor.tinnovatest.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("brands")
public class BrandController extends AbstractController<Brand, UUID, BrandRequest, BrandResponse> {

    @Autowired
    public BrandController(IService<Brand, UUID> service,
                           IMapper<BrandRequest, Brand> requestMapper,
                           IMapper<Brand, BrandResponse> responseMapper) {
        super(service, requestMapper, responseMapper);
    }

}
