package com.sunglowsys.dto;

import com.sunglowsys.domain.Hotel;
import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.domain.RoomType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatePlanDto {
    private String name;
    private Hotel hotel;
    private RoomType roomType;

    private Integer singleOccupancy;
    private Integer doubleOccupancy;
    private double extraAdultPrice;
    private double extraChildPrice;
    private Integer applicableDays;
    private RatePlan ratePlan;
}
