package com.cpulover.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpulover.springdemo.entity.Customer;
import com.cpulover.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject CustomerDAO
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model model) {
		// get customers from the DAO
		List<Customer> customerList = customerService.getCustomers();

		// add the result to the model
		model.addAttribute("customers", customerList);
		
		//return JSP page
		return "list-customer";
	}
}
