package com.cafesync.CafeSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cafesync.CafeSync.entity.OrderItem;
import com.cafesync.CafeSync.service.OrderItemService;

@Controller
@RequestMapping("/orderitems")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public String getAllOrderItems(Model model) {
        model.addAttribute("orderItems", orderItemService.getAllOrderItems());
        return "orderitems";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("orderItem", new OrderItem());
        return "add-orderitem";
    }

    @PostMapping("/save")
    public String saveOrderItem(@ModelAttribute OrderItem orderItem) {
        orderItemService.saveOrderItem(orderItem);
        return "redirect:/orderitems";
    }
}