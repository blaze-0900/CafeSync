package com.cafesync.CafeSync.service;

import java.util.List;
import java.util.Optional;

import com.cafesync.CafeSync.entity.Orders;

public interface OrdersService {

    Orders saveOrder(Orders order);

    List<Orders> getAllOrders();

    Optional<Orders> getOrderById(Long id);

    Orders updateOrder(Orders order);

    void deleteOrder(Long id);

}
