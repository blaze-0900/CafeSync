package com.cafesync.CafeSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cafesync.CafeSync.entity.Notification;
import com.cafesync.CafeSync.service.FranchiseService;
import com.cafesync.CafeSync.service.NotificationService;

@Controller
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private FranchiseService franchiseService;

    @GetMapping
    public String getAllNotifications(Model model) {
        model.addAttribute("notifications", notificationService.getAllNotifications());
        return "notifications";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {

        model.addAttribute("notification", new Notification());
        model.addAttribute("franchises", franchiseService.getAllFranchises());

        return "add-notification";
    }

    @PostMapping("/save")
    public String saveNotification(@ModelAttribute Notification notification) {
        notificationService.saveNotification(notification);
        return "redirect:/notifications";
    }
}