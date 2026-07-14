package com.cafesync.CafeSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cafesync.CafeSync.entity.User;
import com.cafesync.CafeSync.service.CategoryService;
import com.cafesync.CafeSync.service.CustomerService;
import com.cafesync.CafeSync.service.EmployeeService;
import com.cafesync.CafeSync.service.ExpenseService;
import com.cafesync.CafeSync.service.FranchiseService;
import com.cafesync.CafeSync.service.InventoryService;
import com.cafesync.CafeSync.service.NotificationService;
import com.cafesync.CafeSync.service.OrdersService;
import com.cafesync.CafeSync.service.PaymentService;
import com.cafesync.CafeSync.service.ProductService;
import com.cafesync.CafeSync.service.UserService;

import jakarta.servlet.http.HttpSession;

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
	@Autowired
	private UserService userService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private PaymentService paymentService;


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
	public String managerDashboard(Model model, HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");

        model.addAttribute("user", user);

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
	
	@GetMapping("/admin-dashboard")
	public String adminDashboard(Model model) {
		

	    model.addAttribute("role", "ADMIN");

	    model.addAttribute("userCount",
	            userService.getAllUsers().size());

	    model.addAttribute("franchiseCount",
	            franchiseService.getAllFranchises().size());

	    model.addAttribute("employeeCount",
	            employeeService.getAllEmployees().size());

	    model.addAttribute("productCount",
	            productService.getAllProducts().size());

	    model.addAttribute("orderCount",
	            ordersService.getAllOrders().size());

	    model.addAttribute("categoryCount",
	            categoryService.getAllCategories().size());

	    model.addAttribute("notificationCount",
	            notificationService.getAllNotifications().size());

	    double revenue = paymentService.getAllPayments()
	            .stream()
	            .filter(p -> p.getAmount() != null)
	            .mapToDouble(p -> p.getAmount())
	            .sum();

	    model.addAttribute("revenue", revenue);

	    return "dashboard/admin-dashboard";
	}
	@GetMapping("/employee-dashboard")
	public String employeeDashboard(Model model) {
		
      

	    model.addAttribute("role", "EMPLOYEE");

	    model.addAttribute("todayOrders",
	            ordersService.getAllOrders().size());

	    model.addAttribute("customerCount",
	            customerService.getAllCustomers().size());

	    model.addAttribute("productsSold",
	            ordersService.getAllOrders().size());

	    double todaySales = paymentService.getAllPayments()
	            .stream()
	            .filter(p -> p.getAmount() != null)
	            .mapToDouble(p -> p.getAmount())
	            .sum();

	    model.addAttribute("todaySales", todaySales);

	    model.addAttribute("recentOrders",
	            ordersService.getAllOrders());

	    return "dashboard/employee-dashboard";
	}

}
