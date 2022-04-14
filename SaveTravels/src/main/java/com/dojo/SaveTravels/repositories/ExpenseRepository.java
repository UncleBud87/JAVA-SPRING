package com.dojo.SaveTravels.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dojo.SaveTravels.models.Expense;

public interface ExpenseRepository extends CrudRepository<Expense,Long>{

}
