package com.cafesync.CafeSync.service;



import java.util.List;
import java.util.Optional;

import com.cafesync.CafeSync.entity.Customer;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(Long id);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Long id);

}