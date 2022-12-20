package com.sunglowsys.dto;

import com.sunglowsys.domain.Hotel;
import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.domain.RoomType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class BookingDetailDto {
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String gender;
    private Integer age;
    private String idType;
    private String idNo;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkInDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkOutDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate bookingDate;

    private Integer noOfAdult;
    private Integer noOfChild;
    private Integer totalGuest;
    private Integer noOfRoom;
    private Integer noOfNight;
    private Hotel hotel;
    private RoomType roomType;
    private RatePlan ratePlan;

}
