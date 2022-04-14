package com.dojo.SaveTravels.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Expense {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	public Expense() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	public void setExpense_type(String expense_type) {
		this.expense_type = expense_type;
	}
	
	public String getExpense_type() {
		return expense_type;
	}
	
	public void setExpense_vendor(String expense_vendor) {
		this.expense_vendor = expense_vendor;
	}
	
	public String getExpense_vendor() {
		return expense_vendor;
	}
	
	public void setExpense_amount(double expense_amount) {
		this.expense_amount = expense_amount;
	}
	
	public double getExpense_amount() {
		return expense_amount;
	}
	
	@Size(min=1,max=255,message="Expense cannot be blank")
	private String expense_type;
	
	@Size(min=1,max=255,message="vendor cannot be blank")
	private String expense_vendor;
	
	@NotNull
	private double expense_amount;
	
};
