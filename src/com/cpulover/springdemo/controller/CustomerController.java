package com.cpulover.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpulover.springdemo.dao.CustomerDAO;
import com.cpulover.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject CustomerDAO
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping("/list")
	public String listCustomer(Model model) {
		// get customers from the DAO
		List<Customer> customerList = customerDAO.getCustomers();

		// add the result to the model
		model.addAttribute("customers", customerList);
		
		//return JSP page
		return "list-customer";
	}
}
