package com.nsgrigorjev.controller;


import com.nsgrigorjev.database.entity.User;
import com.nsgrigorjev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class UserController {
    private final UserService userService;
    private static final String REDIRECT = "redirect:/";

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = GET)
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "all_users";
    }

    @RequestMapping(value = "/new", method = GET)
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "user_create";
    }

    @RequestMapping(value = "/create", method = POST)
    public String saveNewUser(@ModelAttribute("user") @Valid User user,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_create";
        } else {
            userService.persist(user);
            return REDIRECT;
        }
    }

    @RequestMapping(value = "/edit", method = GET)
    public String updateUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "user_edit";
    }

    @RequestMapping(value = "/update", method = POST)
    public String saveUpdateUser(@ModelAttribute("user") @Valid User user,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_edit";
        } else {
            userService.update(user);
            return REDIRECT;
        }
    }

    @RequestMapping(value = "/remove", method = GET)
    public String deleteUser(@RequestParam("id") Long id,
                             @ModelAttribute("user") User user) {
        userService.deleteById(id);
        return REDIRECT;
    }
}