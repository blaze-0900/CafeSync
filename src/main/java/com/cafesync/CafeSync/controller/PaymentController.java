package com.cafesync.CafeSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cafesync.CafeSync.entity.Payment;
import com.cafesync.CafeSync.service.PaymentService;

@Controller
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public String getAllPayments(Model model) {
        model.addAttribute("payments", paymentService.getAllPayments());
        return "payments";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("payment", new Payment());
        return "add-payment";
    }

    @PostMapping("/save")
    public String savePayment(@ModelAttribute Payment payment) {
        paymentService.savePayment(payment);
        return "redirect:/payments";
    }
}