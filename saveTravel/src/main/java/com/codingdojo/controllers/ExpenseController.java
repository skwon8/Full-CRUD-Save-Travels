package com.codingdojo.controllers;

import javax.validation.Valid;

import com.codingdojo.models.Expense;
import com.codingdojo.services.ExpenseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExpenseController
{
	// Always have this on the Controller
	@Autowired
	private ExpenseService expenseService;

	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}

	@GetMapping("/expense")
	public String expense_new(Model model) {
		model.addAttribute("expense", new Expense());
		model.addAttribute("expenses", expenseService.findAll());
		return "expense_new";
	}

	@PostMapping("/song")
	public String expense_create(@Valid @ModelAttribute("expense") Expense expense, BindingResult res, Model model) {
		if (res.hasErrors()) {
			model.addAttribute("expenses", expenseService.findAll());
			return "expense_new";
		}
		expenseService.Create(expense);
		return "redirect:/expense";
	}

	@GetMapping("/expense/{id}")
	public String expense_show (@PathVariable("id") Long id, Model model) {

		model.addAttribute("expense", expenseService.ReadOne(id));
		return "expense_show";
	}

	@GetMapping("/expense/{id}/edit")
	public String expense_edit (@PathVariable("id") Long id, Model model) {

		Expense expense = expenseService.ReadOne(id);
		if (expense == null) return "redirect:/expense";

		model.addAttribute("expense", expenseService.ReadOne(id));
		return "expense_edit";
	}

	@PostMapping("/expense/{id}/update")
	public String expense_update(@Valid @ModelAttribute("expense") Expense expense, BindingResult res, Model model, @PathVariable("id") Long id) {
		
		if (res.hasErrors()) {
			return "expense_edit";

		}
		expenseService.Update(expense);
		return "redirect:/expense";
	}

	@PostMapping("/expense/{id}/delete")
	public String expense_delete(@PathVariable("id") Long id) {
		expenseService.Delete(id);
		return "redirect:/expense";
	}
};