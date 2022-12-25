package com.sunglowsys.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "rate_calendar")
public class RateCalendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "applicable_date")
    private LocalDate applicableDate;

    @Column(name = "single_occupancy")
    private Integer singleOccupancy;

    @Column(name = "double_occupancy")
    private Integer doubleOccupancy;

    @Column(name = "extra_adult_price")
    private double extraAdultPrice;

    @Column(name = "extra_child_price")
    private double extraChildPrice;


    @Column(name = "applicable_days")
    private Integer applicableDays;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private RatePlan ratePlan;

    public RateCalendar(LocalDate applicableDate, Integer singleOccupancy, Integer doubleOccupancy, double extraAdultPrice, double extraChildPrice, Integer applicableDays, Hotel hotel, RatePlan ratePlan) {
        this.applicableDate = applicableDate;
        this.singleOccupancy = singleOccupancy;
        this.doubleOccupancy = doubleOccupancy;
        this.extraAdultPrice = extraAdultPrice;
        this.extraChildPrice = extraChildPrice;
        this.applicableDays = applicableDays;
        this.hotel = hotel;
        this.ratePlan = ratePlan;
    }



    public RateCalendar(Integer singleOccupancy, Integer doubleOccupancy, double extraAdultPrice, double extraChildPrice, Integer applicableDays, RatePlan result) {
    }
}
