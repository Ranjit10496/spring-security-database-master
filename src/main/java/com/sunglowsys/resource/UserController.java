package com.sunglowsys.resource;

import com.sunglowsys.domain.User;
import com.sunglowsys.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    public ModelAndView createUser(@ModelAttribute User user) {
        User result = userService.save(user);
        return new ModelAndView("register","user", new User());
    }
}
