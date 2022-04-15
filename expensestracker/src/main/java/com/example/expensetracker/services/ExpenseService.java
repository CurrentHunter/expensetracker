package com.example.expensetracker.services;

import java.util.List;

import com.example.expensetracker.models.Expense;

public interface ExpenseService {
		List<Expense> findAll(); 
		
		void save(Expense expense);
		
		Expense findById(Long id);
}
