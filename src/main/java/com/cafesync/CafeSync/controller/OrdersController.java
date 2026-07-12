package com.cafesync.CafeSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cafesync.CafeSync.entity.Orders;
import com.cafesync.CafeSync.service.OrdersService;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping
    public String getAllOrders(Model model) {
        model.addAttribute("orders", ordersService.getAllOrders());
        return "orders";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("order", new Orders());
        return "add-order";
    }

    @PostMapping("/save")
    public String saveOrder(@ModelAttribute Orders order) {
        ordersService.saveOrder(order);
        return "redirect:/orders";
    }
}