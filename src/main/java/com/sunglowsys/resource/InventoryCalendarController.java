package com.sunglowsys.resource;

import com.sunglowsys.domain.InventoryCalendar;
import com.sunglowsys.service.InventoryCalendarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class InventoryCalendarController {
    private final InventoryCalendarService inventoryCalendarService;

    public InventoryCalendarController(InventoryCalendarService inventoryCalendarService) {
        this.inventoryCalendarService = inventoryCalendarService;
    }
    @GetMapping("/inventory-calendar")
    public ModelAndView getCalendar() {
        List<InventoryCalendar> result = inventoryCalendarService.findAll();
        return new ModelAndView("inventory-calendar" , "calendars", result);
    }
}
