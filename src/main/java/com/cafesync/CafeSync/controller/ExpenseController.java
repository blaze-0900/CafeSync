package com.cafesync.CafeSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cafesync.CafeSync.entity.Expense;
import com.cafesync.CafeSync.entity.ExpenseType;
import com.cafesync.CafeSync.entity.Status;
import com.cafesync.CafeSync.service.ExpenseService;
import com.cafesync.CafeSync.service.FranchiseService;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;
    @Autowired 
    private FranchiseService franchiseService;

    @GetMapping
    public String getAllExpenses(Model model) {
        model.addAttribute("expenses", expenseService.getAllExpenses());
        return "expenses";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {

        model.addAttribute("expense", new Expense());

        model.addAttribute("franchises", franchiseService.getAllFranchises());
        model.addAttribute("expenseTypes", ExpenseType.values());
        model.addAttribute("statuses", Status.values());

        return "add-expense";
    }

    @PostMapping("/save")
    public String saveExpense(@ModelAttribute Expense expense) {
        expenseService.saveExpense(expense);
        return "redirect:/expenses";
    }
}