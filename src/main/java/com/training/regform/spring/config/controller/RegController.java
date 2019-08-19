package com.training.regform.spring.config.controller;

import com.training.regform.spring.config.entity.Role;
import com.training.regform.spring.config.entity.User;
import com.training.regform.spring.config.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegController {

    private final UserService userService;

    public RegController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/reg")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = (User) userService.loadUserByUsername(user.getUsername());
        if (userFromDb != null) {
            model.put("message", "User is already exists");
            return "reg";
        }
        user.setRoles(Collections.singleton(Role.USER));
        userService.saveNewUser(user);
        return
                "redirect:/login";
    }
}
