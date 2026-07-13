package com.cafesync.CafeSync.controller;
import java.util.Optional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cafesync.CafeSync.dto.BillItem;
import com.cafesync.CafeSync.entity.Employee;
import com.cafesync.CafeSync.entity.OrderItem;
import com.cafesync.CafeSync.entity.OrderStatus;
import com.cafesync.CafeSync.entity.Orders;
import com.cafesync.CafeSync.entity.Payment;
import com.cafesync.CafeSync.entity.PaymentMethod;
import com.cafesync.CafeSync.entity.PaymentStatus;
import com.cafesync.CafeSync.entity.Product;
import com.cafesync.CafeSync.service.CustomerService;
import com.cafesync.CafeSync.service.EmployeeService;
import com.cafesync.CafeSync.service.OrderItemService;
import com.cafesync.CafeSync.service.OrdersService;
import com.cafesync.CafeSync.service.PaymentService;
import com.cafesync.CafeSync.service.ProductService;

@Controller
public class PosController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    private List<BillItem> bill = new ArrayList<>();
    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/pos")
    public String showPOS(Model model) {

        double grandTotal = bill.stream()
                .mapToDouble(BillItem::getTotal)
                .sum();

        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("bill", bill);
        model.addAttribute("grandTotal", grandTotal);

        return "pos";
    }
    @PostMapping("/pos/add")
    public String addToBill(@RequestParam Long productId,
                            @RequestParam Integer quantity) {


        Product product = productService.getProductById(productId).orElse(null);


        if(product != null){


            for(BillItem item : bill){

                if(item.getProductId().equals(productId)){


                    item.setQuantity(
                        item.getQuantity() + quantity
                    );


                    item.setTotal(
                        item.getQuantity() * item.getPrice()
                    );


                    return "redirect:/pos";
                }
            }



            BillItem item = new BillItem();

            item.setProductId(product.getProductId());
            item.setProductName(product.getProductName());
            item.setPrice(product.getPrice());
            item.setQuantity(quantity);

            item.setTotal(
                product.getPrice() * quantity
            );


            bill.add(item);

        }


        return "redirect:/pos";
    }
    
    
    
   
    @GetMapping("/pos/remove/{id}")
    public String removeItem(@PathVariable Long id){

        bill.removeIf(
            item -> item.getProductId().equals(id)
        );

        return "redirect:/pos";
    }
    @GetMapping("/pos/clear")
    public String clearBill(){

        bill.clear();

        return "redirect:/pos";
    }
    @PostMapping("/pos/place-order")
    public String placeOrder(@RequestParam String paymentMethod) {

    	 System.out.println("1. PLACE ORDER METHOD CALLED");

    	    if(bill.isEmpty()) {
    	        System.out.println("2. BILL IS EMPTY");
    	        return "redirect:/pos";
    	    }

    	    System.out.println("3. BILL SIZE: " + bill.size());


    	    Employee employee =
    	            employeeService.getEmployeeById(1L).orElse(null);


    	    if(employee == null) {
    	        System.out.println("4. EMPLOYEE NOT FOUND");
    	        return "redirect:/pos";
    	    }

    	    System.out.println("5. EMPLOYEE FOUND");
        if(bill.isEmpty()) {
            return "redirect:/pos";
        }





        // Create Order

        Orders order = new Orders();

        order.setEmployee(employee);

        order.setFranchise(
                employee.getFranchise()
        );

        order.setOrderDateTime(
                LocalDateTime.now()
        );


        double total = bill.stream()
                .mapToDouble(BillItem::getTotal)
                .sum();


        order.setTotalAmount(total);

        order.setOrderStatus(
                OrderStatus.COMPLETED
        );


        order.setPaymentStatus(
                PaymentStatus.PAID
        );


        Orders savedOrder =
                ordersService.saveOrder(order);



        // Create Order Items

        for(BillItem item : bill) {


            OrderItem orderItem = new OrderItem();


            orderItem.setOrder(savedOrder);


            Product product =
                    productService
                    .getProductById(item.getProductId())
                    .orElse(null);


            orderItem.setProduct(product);

            orderItem.setQuantity(
                    item.getQuantity()
            );


            orderItem.setUnitPrice(
                    item.getPrice()
            );


            orderItem.setTotalPrice(
                    item.getTotal()
            );


            orderItemService.saveOrderItem(orderItem);

        }



        // Create Payment

        Payment payment = new Payment();


        payment.setOrder(savedOrder);

        payment.setAmount(total);


        payment.setPaymentMethod(
                PaymentMethod.valueOf(paymentMethod)
        );


        payment.setPaymentStatus(
                PaymentStatus.PAID
        );


        payment.setPaymentDate(
                LocalDateTime.now()
        );


        paymentService.savePayment(payment);



        // Empty cart after successful order

        bill.clear();


        return "redirect:/pos";

    }
}