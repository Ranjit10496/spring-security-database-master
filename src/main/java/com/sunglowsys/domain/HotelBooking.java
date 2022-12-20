package com.sunglowsys.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
@NoArgsConstructor
@Data
@Entity
@Table(name = "hotel_booking")
public class HotelBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "check_in_date")
    private LocalDate checkInDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "check_out_date")
    private LocalDate checkOutDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "no_of_Adult")
    private Integer noOfAdult;

    @Column(name = "no_of_child")
    private Integer noOfChild;

    @Column(name = "total_guest")
    private Integer totalGuest;

    @Column(name = "no_of_rooms")
    private Integer noOfRoom;

    @Column(name = "no_of_night")
    private Integer noOfNight;

    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Hotel hotel;
    @ManyToOne
    private RoomType roomType;
    @ManyToOne
    private RatePlan ratePlan;

    public HotelBooking(LocalDate checkInDate, LocalDate checkOutDate, LocalDate bookingDate, Integer noOfAdult, Integer noOfChild, Integer noOfRoom, Integer noOfNight, Customer customer, Hotel hotel, RoomType roomType, RatePlan ratePlan) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingDate = bookingDate;
        this.noOfAdult = noOfAdult;
        this.noOfChild = noOfChild;
        this.noOfRoom = noOfRoom;
        this.noOfNight = noOfNight;
        this.customer = customer;
        this.hotel = hotel;
        this.roomType = roomType;
        this.ratePlan = ratePlan;
    }
}
