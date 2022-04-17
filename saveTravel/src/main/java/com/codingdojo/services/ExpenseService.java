package com.codingdojo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.codingdojo.models.Expense;
import com.codingdojo.repositories.ExpenseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository er;

    public ExpenseService (ExpenseRepository er ) {
        this.er = er;
    }
    
    // Create
    public void Create (Expense expense) {
        er.save(expense);
    }
    // Read
    public Expense ReadOne (Long id) {
        Optional <Expense> expense = er.findById(id);
        return expense.isPresent()?expense.get():null;
    }
    // Read
    public ArrayList<Expense> findAll () {
        ArrayList<Expense> expenses =(ArrayList<Expense>)er.findAll();
        return expenses;
    }
    // Update
    public void Update (Expense expense) {
        Create(expense);
    }
    // Delete
    public void Delete(Long id) {
        er.deleteById(id);
    }
};
