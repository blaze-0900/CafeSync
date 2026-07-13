package com.cafesync.CafeSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cafesync.CafeSync.entity.Role;
import com.cafesync.CafeSync.entity.Status;
import com.cafesync.CafeSync.entity.User;
import com.cafesync.CafeSync.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("roles", Role.values());
        model.addAttribute("statuses", Status.values());

        return "add-user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {


        if(user.getRole() == Role.EMPLOYEE) {

            user.setRolePassword(null);

        }


        userService.saveUser(user);

        return "redirect:/users";
    }
}