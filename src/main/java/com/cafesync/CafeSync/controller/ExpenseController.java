package com.cafesync.CafeSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cafesync.CafeSync.entity.Expense;
import com.cafesync.CafeSync.service.ExpenseService;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public String getAllExpenses(Model model) {
        model.addAttribute("expenses", expenseService.getAllExpenses());
        return "expenses";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("expense", new Expense());
        return "add-expense";
    }

    @PostMapping("/save")
    public String saveExpense(@ModelAttribute Expense expense) {
        expenseService.saveExpense(expense);
        return "redirect:/expenses";
    }
}