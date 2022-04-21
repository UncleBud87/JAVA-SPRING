package com.dojo.SaveTravels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.SaveTravels.models.Expense;
import com.dojo.SaveTravels.services.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService=expenseService;
	}
	
	@GetMapping("/expense")
	public String expense_new(Model model) {
		model.addAttribute("expense",new Expense());
		model.addAttribute("expenses",expenseService.ReadAll());
		return "expense_new";
	}
	@PostMapping("/expense")
	public String expense_create(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult res,
			Model model) {
		if(res.hasErrors()) {
			model.addAttribute("expenses",expenseService.ReadAll());
			return "expense_new";
		}
		expenseService.Create(expense);
		return "redirect:/expense";
	}
	@GetMapping("/expense/{id}")
	public String show_expense(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense",expenseService.ReadOne(id));
		return "show_expense";
	}
	@GetMapping("/expense/{id}/edit")
	public String edit_expense(@PathVariable("id") Long id, Model model) 
	{
		Expense expense=expenseService.ReadOne(id);
		if(expense==null) return "redirect:/expense";
		model.addAttribute("expense",expenseService.ReadOne(id));
		return "edit_expense";
	}
	@PostMapping("/expense/{id}/update")
	public String update_expense(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult res,
			Model model,
			@PathVariable("id") Long id) {
		if(res.hasErrors()) {
			System.out.println("ERROR in update_expense");
			return "edit_expense";
		}
		expenseService.Update(expense);
		return "redirect:/expense";
	}
	@PostMapping("/expense/{id}/delete")
	public String delete_expense(@PathVariable("id") Long id) {
		expenseService.Delete(id);
		return "redirect:/expense";
	}
	
}

