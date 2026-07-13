package com.cafesync.CafeSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cafesync.CafeSync.service.CustomerService;
import com.cafesync.CafeSync.service.EmployeeService;
import com.cafesync.CafeSync.service.ExpenseService;
import com.cafesync.CafeSync.service.FranchiseService;
import com.cafesync.CafeSync.service.InventoryService;
import com.cafesync.CafeSync.service.OrdersService;
import com.cafesync.CafeSync.service.ProductService;

@Controller
public class DashboardController {
	@Autowired
	private FranchiseService franchiseService;

	@Autowired
	private OrdersService ordersService;

	@Autowired
	private ExpenseService expenseService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private InventoryService inventoryService;


	@GetMapping("/owner-dashboard")
	public String ownerDashboard(Model model) {
		model.addAttribute("role","OWNER");

	    model.addAttribute("totalFranchise",
	            franchiseService.getAllFranchises().size());

	    model.addAttribute("totalOrders",
	            ordersService.getAllOrders().size());

	    model.addAttribute("expenses",
	            expenseService.getAllExpenses().size());

	    model.addAttribute("totalProducts",
	            productService.getAllProducts().size());

	    return "dashboard/owner-dashboard";
	}
	
	@GetMapping("/manager-dashboard")
	public String managerDashboard(Model model) {
		model.addAttribute("role","MANAGER");

	    model.addAttribute("employeeCount",
	            employeeService.getAllEmployees().size());

	    model.addAttribute("productCount",
	            productService.getAllProducts().size());

	    model.addAttribute("customerCount",
	            customerService.getAllCustomers().size());

	    model.addAttribute("inventoryCount",
	            inventoryService.getAllInventory().size());

	    return "dashboard/manager-dashboard";
	}

}
