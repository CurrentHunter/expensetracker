package com.example.expensetracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.expensetracker.models.Expense;
import com.example.expensetracker.services.ExpenseService;


@Controller
public class MasterController {

	@Autowired
	ExpenseService expenseService;
	
    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("message", "List of expenses");
        List<Expense> expenses = expenseService.findAll();
        mv.addObject("expenses", expenses);
        return mv;
    }
    
    @RequestMapping("/expense")
    public ModelAndView addexpense(){
        ModelAndView mv = new ModelAndView("expense");
        mv.addObject("expense", new Expense());
        return mv;
    }
    
    @PostMapping(value="/expense")
    public String save(@ModelAttribute("expense") Expense expense){
        expenseService.save(expense);
        return "redirect:/";
    }
    
    @RequestMapping(value="/expense/{id}")
    public ModelAndView edit(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("expense");
        Expense expense = expenseService.findById(id);
        mv.addObject("expense", expense);
        return mv;
    }
}
