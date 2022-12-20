package com.sunglowsys.resource;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.domain.HotelBooking;
import com.sunglowsys.dto.BookingDetailDto;
import com.sunglowsys.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class HotelBookingController {
    private final Logger logger = LoggerFactory.getLogger(HotelBookingController.class);
    private final HotelBookingService hotelBookingService;
    private final HotelService hotelService;
    private final RoomTypeService roomTypeService;
    private final RatePlanService ratePlanService;
    private final CustomerService customerService;

    public HotelBookingController(HotelBookingService hotelBookingService, HotelService hotelService, RoomTypeService roomTypeService, RatePlanService ratePlanService, CustomerService customerService) {
        this.hotelBookingService = hotelBookingService;
        this.hotelService = hotelService;
        this.roomTypeService = roomTypeService;
        this.ratePlanService = ratePlanService;
        this.customerService = customerService;
    }
    @GetMapping("/bookings")
    public ModelAndView getBooking() {
        List<HotelBooking> result = hotelBookingService.getAll();
        return new ModelAndView("hotel-booking","bookings", result);
    }
    @GetMapping("/bookings-create")
    public ModelAndView loadForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hotels", hotelService.getAll());
        modelAndView.addObject("roomTypes", roomTypeService.getAll());
        modelAndView.addObject("ratePlans", ratePlanService.getAll());
        modelAndView.addObject("booking", new BookingDetailDto());
        modelAndView.setViewName("hotel-booking-new");
        return modelAndView;

    }
    @PostMapping("/bookings-create")
    public ModelAndView createBooking(@ModelAttribute BookingDetailDto bookingDetailDto) {
        Customer customer = new Customer(
                bookingDetailDto.getFirstName(),
                bookingDetailDto.getLastName(),
                bookingDetailDto.getEmail(),
                bookingDetailDto.getMobile(),
                bookingDetailDto.getGender(),
                bookingDetailDto.getAge(),
                bookingDetailDto.getIdType(),
                bookingDetailDto.getIdNo()
        );


        Customer result = customerService.save(customer);

        HotelBooking hotelBooking = new HotelBooking(
                bookingDetailDto.getCheckInDate(),
                bookingDetailDto.getCheckOutDate(),
                bookingDetailDto.getBookingDate(),
                bookingDetailDto.getNoOfAdult(),
                bookingDetailDto.getNoOfChild(),
                bookingDetailDto.getNoOfRoom(),
                bookingDetailDto.getNoOfNight(),
                result,
                bookingDetailDto.getHotel(),
                bookingDetailDto.getRoomType(),
                bookingDetailDto.getRatePlan()
        );
        hotelBookingService.save(hotelBooking);
        return new ModelAndView("redirect:/bookings");
    }
}
