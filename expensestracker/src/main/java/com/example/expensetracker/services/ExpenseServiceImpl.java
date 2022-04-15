package com.example.expensetracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expensetracker.models.Expense;
import com.example.expensetracker.repository.ExpenseRepository;



@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;
	
	@Override
	public List<Expense> findAll() {
		return expenseRepository.findAll();
		}

	@Override
	public void save(Expense expense) {
		expense.setCreatedAt(System.currentTimeMillis());
		expenseRepository.save(expense);		
	}

	@Override
	public Expense findById(Long id) {
		if(expenseRepository.findById(id).isPresent()){
			return expenseRepository.findById(id).get();
		}
		return null;
	}

}
