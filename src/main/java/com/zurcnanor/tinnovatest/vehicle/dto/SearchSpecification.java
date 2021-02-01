package com.zurcnanor.tinnovatest.vehicle.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchSpecification {

    private String q = "";

    private String startDate;

    private String endDate;

}
