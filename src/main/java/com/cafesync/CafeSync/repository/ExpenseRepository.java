package com.cafesync.CafeSync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cafesync.CafeSync.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}