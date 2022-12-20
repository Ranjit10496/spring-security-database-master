package com.sunglowsys.resource;

import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.service.HotelService;
import com.sunglowsys.service.RatePlanService;
import com.sunglowsys.service.RoomTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class RatePlanController {
    private final RatePlanService ratePlanService;
    private final HotelService hotelService;
    private final RoomTypeService roomTypeService;

    public RatePlanController(RatePlanService ratePlanService, HotelService hotelService, RoomTypeService roomTypeService) {
        this.ratePlanService = ratePlanService;
        this.hotelService = hotelService;
        this.roomTypeService = roomTypeService;
    }
    @GetMapping("/rate-plans")
    public ModelAndView getAllRatePlan() {
        List<RatePlan> result = ratePlanService.getAll();
        return new ModelAndView("rate-plan","ratePlans", result);
    }
    @GetMapping("/rate-plan-create")
    public ModelAndView loadRatePlanForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hotels", hotelService.getAll());
        modelAndView.addObject("roomTypes", roomTypeService.getAll());
        modelAndView.addObject("ratePlan", new RatePlan());
        modelAndView.setViewName("rate-plan-new");
        return modelAndView;
    }
    @PostMapping("rate-plan-create")
    public ModelAndView createRatePlan(@ModelAttribute RatePlan ratePlan) {
        RatePlan resutl = ratePlanService.save(ratePlan);
        return new ModelAndView("redirect:/rate-plans");
    }
}
