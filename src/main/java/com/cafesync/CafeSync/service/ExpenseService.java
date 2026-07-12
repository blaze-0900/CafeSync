package com.cafesync.CafeSync.service;

import java.util.List;
import java.util.Optional;

import com.cafesync.CafeSync.entity.Expense;

public interface ExpenseService {

    Expense saveExpense(Expense expense);

    List<Expense> getAllExpenses();

    Optional<Expense> getExpenseById(Long id);

    Expense updateExpense(Expense expense);

    void deleteExpense(Long id);

}