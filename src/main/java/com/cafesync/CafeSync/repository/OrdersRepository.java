package com.cafesync.CafeSync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cafesync.CafeSync.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
