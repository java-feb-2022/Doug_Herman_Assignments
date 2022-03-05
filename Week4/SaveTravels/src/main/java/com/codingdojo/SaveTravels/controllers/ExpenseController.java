package com.codingdojo.SaveTravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.SaveTravels.models.Expense;
import com.codingdojo.SaveTravels.services.ExpenseService;

@Controller
public class ExpenseController {
	private final ExpenseService expenseService;
	
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@GetMapping("/expenses")
	public String index(@ModelAttribute("newExpense") Expense expense, 
			Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("allExpenses", expenses);
		
		return "index.jsp";
	}
	
	@PostMapping("/expenses/new")
	public String addExpense(@Valid @ModelAttribute("newExpense") Expense expense, 
			BindingResult result, 
			Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("allExpenses", expenses);
		
		if(result.hasErrors())
			return "/index.jsp";
		else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, 
			@ModelAttribute("newExpense") Expense expense, 
			Model model) {
		model.addAttribute("newExpense", expenseService.findExpense(id));
		return "edit.jsp";
	}
	
	@PostMapping("expenses/edit")
	public String editExpense(@Valid @ModelAttribute("newExpense") Expense expense, 
			BindingResult result) {
		if (result.hasErrors())
			return "/edit.jsp";
		else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
}
