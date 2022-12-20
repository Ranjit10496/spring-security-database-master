package com.sunglowsys.resource;

import com.sunglowsys.domain.Hotel;
import com.sunglowsys.service.HotelService;
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
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @GetMapping("/hotels")
    public ModelAndView getAllHotels() {
        Page<Hotel> result = hotelService.getAll(PageRequest.of(0,10));
        return new ModelAndView("hotel","hotels", result);
    }
    @GetMapping("/hotels-create")
    public ModelAndView loadHotel(Hotel hotel) {
        return new ModelAndView("hotel-new", "hotel", new Hotel());
    }
    @PostMapping("/hotels-create")
    public ModelAndView createHotel(@ModelAttribute Hotel hotel) {
        Hotel result = hotelService.save(hotel);
        return new ModelAndView("redirect:/hotels","hotel",result);
    }

}
