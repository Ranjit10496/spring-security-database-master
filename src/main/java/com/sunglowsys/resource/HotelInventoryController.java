package com.sunglowsys.resource;

import com.sunglowsys.domain.HotelInventory;
import com.sunglowsys.service.HotelInventoryService;
import com.sunglowsys.service.HotelService;
import com.sunglowsys.service.RoomTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class HotelInventoryController {
    private final HotelInventoryService hotelInventoryService;
    private final HotelService hotelService;
    private final RoomTypeService roomTypeService;

    public HotelInventoryController(HotelInventoryService hotelInventoryService, HotelService hotelService, RoomTypeService roomTypeService) {
        this.hotelInventoryService = hotelInventoryService;
        this.hotelService = hotelService;
        this.roomTypeService = roomTypeService;
    }
    @GetMapping("/hotel-inventory-create")
    public ModelAndView loadHotelInventoryForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hotels", hotelService.getAll());
        modelAndView.addObject("roomTypes",roomTypeService.getAll());
        modelAndView.addObject("inventory", new HotelInventory());
        modelAndView.setViewName("hotel-inventory-new");
        return modelAndView;
    }
    @PostMapping("/hotel-inventory-create")
    public ModelAndView createHotelInventory(@ModelAttribute HotelInventory hotelInventory) {
        HotelInventory result = hotelInventoryService.save(hotelInventory);
        return new ModelAndView("redirect:/hotel-inventories");
    }
    @GetMapping("/hotel-inventories")
    public ModelAndView getAllHotelInventories() {
        Page<HotelInventory> result = hotelInventoryService.getAll(PageRequest.of(0,20));
        return new ModelAndView("hotel-inventory","hotelInventories", result);
    }

}
