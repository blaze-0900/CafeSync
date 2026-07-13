package com.cafesync.CafeSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cafesync.CafeSync.entity.Employee;
import com.cafesync.CafeSync.entity.Status;
import com.cafesync.CafeSync.service.EmployeeService;
import com.cafesync.CafeSync.service.FranchiseService;
import com.cafesync.CafeSync.service.UserService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;

    @Autowired
    private FranchiseService franchiseService;

    @GetMapping
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {

        model.addAttribute("employee", new Employee());

        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("franchises", franchiseService.getAllFranchises());
        model.addAttribute("statuses", Status.values());

        return "add-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }
}