package com.dojo.SaveTravels.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.SaveTravels.models.Expense;
import com.dojo.SaveTravels.repositories.ExpenseRepository;


@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository=expenseRepository;
	}
	
	public void Create(Expense expense) {
		expenseRepository.save(expense);
	}
	
	public Expense ReadOne(Long id) {
		Optional<Expense> expense=expenseRepository.findById(id);
		return expense.isPresent()?expense.get():null;
	}
	public ArrayList<Expense> ReadAll(){
		ArrayList<Expense> expenses=(ArrayList<Expense>)expenseRepository.findAll();
		return expenses;
	}
	
	public void Update(Expense expense) {
		Create(expense);
	}
	
	public void Delete(Long id) {
		expenseRepository.deleteById(id);
	}
};
