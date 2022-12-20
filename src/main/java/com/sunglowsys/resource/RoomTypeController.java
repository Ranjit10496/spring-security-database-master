package com.sunglowsys.resource;

import com.sunglowsys.domain.RoomType;
import com.sunglowsys.service.RoomTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class RoomTypeController {
    private final RoomTypeService roomTypeService;

    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }
    @GetMapping("/room-types")
    public String roomType(Model model) {
        Page<RoomType> result = roomTypeService.getAll(PageRequest.of(0,10));
        model.addAttribute("list",result);
        return "room-type";
    }
    @GetMapping("/room-types-create")
    public ModelAndView loadRoomType(RoomType roomType) {
        return new ModelAndView("room-type-new","roomType",new RoomType());
    }
    @PostMapping("/room-types-create")
    public ModelAndView createRoomType(@ModelAttribute RoomType roomType) {
        RoomType result = roomTypeService.save(roomType);
        return new ModelAndView("redirect:/room-types", "roomType", result);
    }
}
