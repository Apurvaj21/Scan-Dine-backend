package com.example.QR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QR.entity.Customer;
import com.example.QR.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<Customer> getallCustomers(){
		return customerService.getallCustomers(); 
	}
	
	
	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
		
	}
	
	@DeleteMapping("/customerId/{customerId}")
	public boolean deleteCustomer(@PathVariable long customerId) {
		return customerService.deleteCustomer(customerId);
	}
	
	@PutMapping("/customerId/{customerId}")
	public Customer updateCustomer(@PathVariable long customerId, @RequestBody Customer updateCustomer) {
		return customerService.updateCustomer(customerId, updateCustomer);
		
	}

}
