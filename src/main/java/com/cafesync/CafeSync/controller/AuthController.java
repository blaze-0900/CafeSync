package com.cafesync.CafeSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cafesync.CafeSync.entity.Role;
import com.cafesync.CafeSync.entity.User;
import com.cafesync.CafeSync.service.UserService;

@Controller
public class AuthController {


    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String login() {

        return "auth/login";
    }


    @PostMapping("/login")
    public String authenticate(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam Role role,
            @RequestParam String rolePassword,
            Model model) {


        User user = userService
                .getUserByEmail(email)
                .orElse(null);


        if(user == null) {

            model.addAttribute(
                    "error",
                    "Invalid Email"
            );

            return "auth/login";
        }


        if(!user.getPassword().equals(password)) {

            model.addAttribute(
                    "error",
                    "Invalid Password"
            );

            return "auth/login";
        }


        if(user.getRole() != role) {

            model.addAttribute(
                    "error",
                    "Invalid Role"
            );

            return "auth/login";
        }


        if(!user.getRolePassword().equals(rolePassword)) {

            model.addAttribute(
                    "error",
                    "Invalid Role Password"
            );

            return "auth/login";
        }



        if(role == Role.OWNER) {

            return "redirect:/owner-dashboard";

        }


        if(role == Role.MANAGER) {

            return "redirect:/manager-dashboard";

        }


        return "redirect:/login";
    }

}
