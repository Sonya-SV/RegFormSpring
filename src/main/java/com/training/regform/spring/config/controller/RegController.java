package com.training.regform.spring.config.controller;

import com.training.regform.spring.config.entity.User;
import com.training.regform.spring.config.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
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
    public String addUser(@Valid User user, BindingResult bindingResult, Model model) {
        if(user.getPassword()!=null &&!user.getPassword().equals(user.getPassword2())) {
            model.addAttribute("passwordErrorDiffer", "Passwords are different!");
            if (bindingResult.hasErrors()) {
                Map<String, String> errors = ValidController.getErrors(bindingResult);
                model.mergeAttributes(errors);
            }
            return "reg";
        }
            User userFromDb = (User) userService.loadUserByUsername(user.getUsername());

        if (userFromDb != null) {
            model.addAttribute("usernameError", "User is already exists");
            return "reg";
        }
        userService.saveNewUser(user);
        return
                "redirect:/login";
    }
}
