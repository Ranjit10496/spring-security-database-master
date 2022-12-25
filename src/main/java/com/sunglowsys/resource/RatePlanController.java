package com.sunglowsys.resource;


import com.sunglowsys.domain.RateCalendar;
import com.sunglowsys.domain.RatePlan;

import com.sunglowsys.dto.RatePlanDto;
import com.sunglowsys.service.HotelService;

import com.sunglowsys.service.RateCalendarService;
import com.sunglowsys.service.RatePlanService;
import com.sunglowsys.service.RoomTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class RatePlanController {
    private final RatePlanService ratePlanService;
    private final HotelService hotelService;
    private final RoomTypeService roomTypeService;
    private final RateCalendarService rateCalendarService;


    public RatePlanController(RatePlanService ratePlanService, HotelService hotelService, RoomTypeService roomTypeService, RateCalendarService rateCalendarService) {
        this.ratePlanService = ratePlanService;
        this.hotelService = hotelService;
        this.roomTypeService = roomTypeService;

        this.rateCalendarService = rateCalendarService;
    }

    @GetMapping("/rate-plans")
    public ModelAndView getAllRatePlan() {
        List<RatePlan> result = ratePlanService.getAll();
        return new ModelAndView("rate-plan", "ratePlans", result);
    }

    @GetMapping("/rate-plan-create")
    public ModelAndView loadRatePlanForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hotels", hotelService.getAll());
        modelAndView.addObject("roomTypes", roomTypeService.getAll());
        modelAndView.addObject("ratePlan", new RatePlanDto());
        modelAndView.setViewName("rate-plan-new");
        return modelAndView;
    }

    //    public ModelAndView createRatePlan(@ModelAttribute RatePlan ratePlan) {
//        RatePlan result = ratePlanService.save(ratePlan);
//        return new ModelAndView("redirect:/rate-plans");
//    }
    @PostMapping("/rate-plan-create")
    public ModelAndView createRatePlan(@ModelAttribute RatePlanDto ratePlanDto) {
        RatePlan ratePlan = new RatePlan(
                ratePlanDto.getName(),
                ratePlanDto.getHotel(),
                ratePlanDto.getRoomType()
        );

        RatePlan result = ratePlanService.save(ratePlan);

        RateCalendar rateCalendar = new RateCalendar(
                ratePlanDto.getSingleOccupancy(),
                ratePlanDto.getDoubleOccupancy(),
                ratePlanDto.getExtraAdultPrice(),
                ratePlanDto.getExtraChildPrice(),
                ratePlanDto.getApplicableDays(),
                result
        );

        rateCalendarService.saveAll(generateRateCalendar(rateCalendar));
        return new ModelAndView("redirect:/rate-plans");


    }

    List<RateCalendar> generateRateCalendar(RateCalendar rateCalendar) {
        List<RateCalendar> calendars = new ArrayList<>();
        LocalDate date = LocalDate.now();
        for (int i = 0; i < 365; i++) {
            calendars.add(new RateCalendar(date.plusDays(i), rateCalendar.getSingleOccupancy(), rateCalendar.getDoubleOccupancy(),
                    rateCalendar.getExtraAdultPrice(), rateCalendar.getExtraChildPrice(), rateCalendar.getApplicableDays(), rateCalendar.getHotel(), rateCalendar.getRatePlan()));
        }
        return calendars;
    }
}
