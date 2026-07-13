package com.cafesync.CafeSync.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {


    @GetMapping("/owner-dashboard")
    public String ownerDashboard(Model model) {


        model.addAttribute("totalFranchise", 5);

        model.addAttribute("revenue", 50000);

        model.addAttribute("totalOrders", 120);

        model.addAttribute("expenses", 15000);


        return "dashboard/owner-dashboard";
    }
    @GetMapping("/manager-dashboard")
    public String managerDashboard(Model model){

        model.addAttribute("todayOrders",20);
        model.addAttribute("todaySales",8000);
        model.addAttribute("employeeCount",10);
        model.addAttribute("pendingExpense",2000);

        return "dashboard/manager-dashboard";
    }


}
