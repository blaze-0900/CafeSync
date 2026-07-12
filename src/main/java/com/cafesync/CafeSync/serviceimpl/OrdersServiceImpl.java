package com.cafesync.CafeSync.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafesync.CafeSync.entity.Orders;
import com.cafesync.CafeSync.repository.OrdersRepository;
import com.cafesync.CafeSync.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Orders saveOrder(Orders order) {
        return ordersRepository.save(order);
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Optional<Orders> getOrderById(Long id) {
        return ordersRepository.findById(id);
    }

    @Override
    public Orders updateOrder(Orders order) {
        return ordersRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        ordersRepository.deleteById(id);
    }
}
