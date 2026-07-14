package com.cafesync.CafeSync.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cafesync.CafeSync.entity.User;

import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalModelAttributes {

    @ModelAttribute("user")
    public User loggedInUser(HttpSession session) {

        return (User) session.getAttribute("loggedInUser");

    }

}
