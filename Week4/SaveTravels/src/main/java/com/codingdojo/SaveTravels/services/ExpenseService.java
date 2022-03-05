package com.codingdojo.SaveTravels.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.SaveTravels.models.Expense;
import com.codingdojo.SaveTravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expense> allExpenses(){
		return expenseRepository.findAll();
	}
	
	public Expense createExpense(Expense e) {
		return expenseRepository.save(e);
	}
}
