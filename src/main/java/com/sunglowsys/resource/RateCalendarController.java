package com.sunglowsys.resource;

import com.sunglowsys.domain.RateCalendar;
import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.dto.RatePlanDto;
import com.sunglowsys.service.HotelService;
import com.sunglowsys.service.RateCalendarService;
import com.sunglowsys.service.RatePlanService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
public class  RateCalendarController {
    private final RateCalendarService rateCalendarService;
    private final HotelService hotelService;
    private final RatePlanService ratePlanService;

    public RateCalendarController(RateCalendarService rateCalendarService, HotelService hotelService, RatePlanService ratePlanService) {
        this.rateCalendarService = rateCalendarService;
        this.hotelService = hotelService;
        this.ratePlanService = ratePlanService;
    }
    @GetMapping("/rate-calendar-create")
    public ModelAndView loadRateCalendarForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hotels", hotelService.getAll());
        modelAndView.addObject("ratePlans", ratePlanService.getAll());
        modelAndView.addObject("rateCalendar", new RateCalendar());
        modelAndView.setViewName("rate-calendar-new");
        return modelAndView;
    }
    @PostMapping("/rate-calendar-create")
    public ModelAndView createRateCalendar(@ModelAttribute RateCalendar rateCalendar) {
        RateCalendar result = rateCalendarService.save(rateCalendar);
        return new ModelAndView("redirect:/rate-calendars");
    }
    @GetMapping("/rate-calendars")
    public ModelAndView getAllRateCalendars() {
        Page<RateCalendar> result = rateCalendarService.getAll(PageRequest.of(0,20));
        return new ModelAndView("rate-calendar", "rateCalendars", result);
    }


}
